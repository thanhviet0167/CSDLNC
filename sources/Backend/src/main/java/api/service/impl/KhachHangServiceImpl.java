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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;
    private final KhachHangMapper khachHangMapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public KhachHangServiceImpl(KhachHangRepository khachHangRepository, KhachHangMapper khachHangMapper) {
        this.khachHangRepository = khachHangRepository;
        this.khachHangMapper = khachHangMapper;
    }

    @Override
    public Optional<KhachHangDTO> getUser(String username) {
        return khachHangRepository.findByUsername(username).map(KhachHangDTO::new);
    }

    @Override
    public Page<KhachHangDTO> getAllUsers(Pageable pageable) {
        return khachHangRepository.findAll(pageable).map(KhachHangDTO::new);
    }

    @Override
    public Long countAllUsers(Pageable pageable) {
        return khachHangRepository.count();
    }

    @Override
    public Page<KhachHangDTO> getUsersWithQuery(Query query, Pageable pageable) {
        return null;
    }

    @Override
    public Long countUsersWithQuery(Query query, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<KhachHangDTO> createUser(ManagedUserVM managedUserVM) throws UsernameAlreadyUsedException {
        KhachHang khachHang = khachHangMapper.managedUserVMToUser(managedUserVM);

        if (StringUtils.isBlank(khachHang.getUsername())) {
            return Optional.empty();
        }

        Optional<KhachHang> userOptional = khachHangRepository.findByUsername(khachHang.getUsername().toLowerCase());

        if (userOptional.isPresent()) {
            throw new UsernameAlreadyUsedException();
        }

        String password = managedUserVM.getPassword();
        String encryptedPassword = passwordEncoder.encode(password);
        khachHang.setPassword(encryptedPassword);

        return Optional.of(khachHangRepository.save(khachHang)).map(KhachHangDTO::new);
    }

    @Override
    public Optional<KhachHangDTO> updateUser(KhachHang khachHang) {
        return Optional.of(khachHangRepository.save(khachHang)).map(KhachHangDTO::new);
    }

    @Override
    public Optional<KhachHangDTO> changePassword(String username, PasswordChangeVM passwordChangeVM) throws InvalidPasswordException {
        Optional<KhachHang> userOptional = khachHangRepository.findByUsername(username.toLowerCase());

        if (!userOptional.isPresent()) {
            return Optional.empty();
        }

        KhachHang khachHang = userOptional.get();

        String currentEncryptedPassword = khachHang.getPassword();
        String currentClearPassword = passwordChangeVM.getOldPassword();
        String newPassword = passwordChangeVM.getNewPassword();

        if (!passwordEncoder.matches(currentClearPassword, currentEncryptedPassword)) {
            throw new InvalidPasswordException();
        }

        String encryptedPassword = passwordEncoder.encode(newPassword);
        khachHang.setPassword(encryptedPassword);

        return Optional.of(khachHangRepository.save(khachHang)).map(KhachHangDTO::new);
    }

    @Override
    public Optional<KhachHangDTO> authenticateUser(LoginVM loginVM) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(String username) {
        khachHangRepository.findByUsername(username.toLowerCase()).ifPresent(khachHangRepository::delete);
    }
}
