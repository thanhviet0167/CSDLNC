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
    
    Optional<KhachHang> getUser(String username);

    Page<KhachHang> getAllUsers(Pageable pageable);

    Long countAllUsers(Pageable pageable);

    Page<KhachHang> getUsersWithQuery(Query query, Pageable pageable);

    Long countUsersWithQuery(Query query,Pageable pageable);

    Optional<KhachHang> createUser(ManagedUserVM managedUserVM) throws UsernameAlreadyUsedException;

    Optional<KhachHang> updateUser(KhachHang khachHang);

    Optional<KhachHang> changePassword(String username, PasswordChangeVM passwordChangeVM) throws InvalidPasswordException;

    String authenticateUser(LoginVM loginVM);

    void deleteUser(String username);
}
