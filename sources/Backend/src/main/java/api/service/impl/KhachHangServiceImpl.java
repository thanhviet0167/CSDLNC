package api.service.impl;

import api.domain.KhachHang;
import api.repository.KhachHangRepository;
import api.service.KhachHangService;
import api.service.dto.KhachHangDTO;
import api.service.mapper.KhachHangMapper;
import api.web.rest.errors.InvalidPasswordException;
import api.web.rest.errors.UsernameAlreadyUsedException;
import api.web.rest.vm.LoginVM;
import api.web.rest.vm.ManagedUserVM;
import api.web.rest.vm.PasswordChangeVM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.Locale;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;
    private final KhachHangMapper khachHangMapper;

    public KhachHangServiceImpl(KhachHangRepository khachHangRepository, KhachHangMapper khachHangMapper) {
        this.khachHangRepository = khachHangRepository;
        this.khachHangMapper = khachHangMapper;
    }

    @Override
    public Optional<KhachHang> getUser(String username) {
        return khachHangRepository.findByUsernameContainingIgnoreCase(username);
    }

    @Override
    public Page<KhachHang> getAllUsers(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public Long countAllUsers(Pageable pageable) {
        return khachHangRepository.count();
    }

    @Override
    public Page<KhachHang> getUsersWithQuery(Query query, Pageable pageable) {
        return null;
    }

    @Override
    public Long countUsersWithQuery(Query query, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<KhachHang> createUser(ManagedUserVM managedUserVM) throws UsernameAlreadyUsedException {
        KhachHang khachHang = khachHangMapper.managedUserVMToUser(managedUserVM);

        if (StringUtils.isBlank(khachHang.getUsername())) {
            return Optional.empty();
        }

        Optional<KhachHang> userOptional = khachHangRepository.findByUsernameContainingIgnoreCase(khachHang.getUsername().toLowerCase());

        if (userOptional.isPresent()) {
            throw new UsernameAlreadyUsedException();
        }

        String password = managedUserVM.getPassword();
//        String encryptedPassword = passwordEncoder.encode(password);
        String encryptedPassword = password;
        khachHang.setPassword(encryptedPassword);

        return Optional.of(khachHangRepository.save(khachHang));
    }

    @Override
    public Optional<KhachHang> updateUser(KhachHang khachHang) {
        return Optional.of(khachHangRepository.save(khachHang));
    }

    @Override
    public Optional<KhachHang> changePassword(String username, PasswordChangeVM passwordChangeVM) throws InvalidPasswordException {
        Optional<KhachHang> userOptional = khachHangRepository.findByUsernameContainingIgnoreCase(username.toLowerCase());

        if (!userOptional.isPresent()) {
            return Optional.empty();
        }

        KhachHang khachHang = userOptional.get();

        String currentEncryptedPassword = khachHang.getPassword();
        String currentClearPassword = passwordChangeVM.getOldPassword();
        String newPassword = passwordChangeVM.getNewPassword();

//        if (!passwordEncoder.matches(currentClearPassword, currentEncryptedPassword)) {
//            throw new InvalidPasswordException();
//        }

        if (!currentEncryptedPassword.equals(currentClearPassword)) {
            throw new InvalidPasswordException();
        }

//        String encryptedPassword = passwordEncoder.encode(newPassword);
        String encryptedPassword = newPassword;
        khachHang.setPassword(encryptedPassword);

        return Optional.of(khachHangRepository.save(khachHang));
    }

    @Override
    public String authenticateUser(LoginVM loginVM) {
        String username = loginVM.getUsername();
        String password = loginVM.getPassword();
        Optional<KhachHang> khachHangOptional = khachHangRepository.findByUsernameContainingIgnoreCaseAndPassword(username, password);

        if (khachHangOptional.isPresent()) {
            return khachHangOptional.get().getUsername().toLowerCase();
        }

        return "";
    }

    @Override
    public void deleteUser(String username) {
        khachHangRepository.findByUsernameContainingIgnoreCase(username.toLowerCase()).ifPresent(khachHangRepository::delete);
    }
}
