package api.service;

import api.domain.KhachHang;
import api.service.dto.KhachHangDTO;
import api.web.rest.errors.InvalidPasswordException;
import api.web.rest.errors.UsernameAlreadyUsedException;
import api.web.rest.vm.LoginVM;
import api.web.rest.vm.ManagedUserVM;
import api.web.rest.vm.PasswordChangeVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.management.Query;
import java.util.Optional;

public interface KhachHangService {
    
    Optional<KhachHangDTO> getUser(String username);

    Page<KhachHangDTO> getAllUsers(Pageable pageable);

    Long countAllUsers(Pageable pageable);

    Page<KhachHangDTO> getUsersWithQuery(Query query, Pageable pageable);

    Long countUsersWithQuery(Query query,Pageable pageable);

    Optional<KhachHangDTO> createUser(ManagedUserVM managedUserVM) throws UsernameAlreadyUsedException;

    Optional<KhachHangDTO> updateUser(KhachHang khachHang);

    Optional<KhachHangDTO> changePassword(String username, PasswordChangeVM passwordChangeVM) throws InvalidPasswordException;

    Optional<KhachHangDTO> authenticateUser(LoginVM loginVM);

    void deleteUser(String username);
}
