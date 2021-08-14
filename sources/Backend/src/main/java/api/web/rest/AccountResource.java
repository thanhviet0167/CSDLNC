package api.web.rest;

import api.domain.KhachHang;
import api.security.JWTService;
import api.security.JWTToken;
import api.service.KhachHangService;
import api.service.dto.KhachHangDTO;
import api.service.mapper.KhachHangMapper;
import api.web.rest.errors.InvalidPasswordException;
import api.web.rest.errors.UsernameAlreadyUsedException;
import api.web.rest.vm.LoginVM;
import api.web.rest.vm.ManagedUserVM;
import api.web.rest.vm.PasswordChangeVM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountResource {

    private final KhachHangService khachHangService;
    private final JWTService jwtService;
    private final KhachHangMapper khachHangMapper;

    public AccountResource(
            KhachHangService khachHangService,
            JWTService jwtService,
            KhachHangMapper khachHangMapper
    ) {
        this.khachHangService = khachHangService;
        this.jwtService = jwtService;
        this.khachHangMapper = khachHangMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<KhachHangDTO> registerAccount(@RequestBody ManagedUserVM managedUserVM) {

        if (isPasswordLengthInvalid(managedUserVM.getPassword())) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Optional<KhachHangDTO> userDtoOptional = khachHangService.createUser(managedUserVM);

            if (userDtoOptional.isPresent()) {
                return ResponseEntity.ok(userDtoOptional.get());
            }
        } catch (UsernameAlreadyUsedException e) {
            e.printStackTrace();

        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<JWTToken> loginAccount(@RequestBody LoginVM loginVM) {
        Optional<KhachHangDTO> authenticatedUserOptional = khachHangService.authenticateUser(loginVM);

        if (!authenticatedUserOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        JWTToken jwtToken = jwtService.createToken(loginVM);

        return ResponseEntity.ok(jwtToken);
    }

    @GetMapping("/account")
    public ResponseEntity<KhachHangDTO> getAccount(
            HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");

        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        KhachHangDTO khachHangDTO = khachHangMapper.toUserDto(jwtService.getAuthentication(token));

        return ResponseEntity.ok(khachHangDTO);
    }

    @PutMapping("/account/change-password")
    public ResponseEntity<KhachHangDTO> updateUser(
            HttpServletRequest request,
            @RequestBody PasswordChangeVM passwordChangeVM
    ) {
        String token = request.getHeader("Authorization");

        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (isPasswordLengthInvalid(passwordChangeVM.getNewPassword())) {
            return ResponseEntity.badRequest().build();
        }

        KhachHang khachHang = jwtService.getAuthentication(token);

        try {
            Optional<KhachHangDTO> userDtoOptional = khachHangService.changePassword(khachHang.getUsername(), passwordChangeVM);

            if (userDtoOptional.isPresent()) {
                return ResponseEntity.ok(userDtoOptional.get());
            }
        } catch (InvalidPasswordException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }

    private static boolean isPasswordLengthInvalid(String password) {
        return (
                StringUtils.isEmpty(password) ||
                        password.length() < ManagedUserVM.PASSWORD_MIN_LENGTH ||
                        password.length() > ManagedUserVM.PASSWORD_MAX_LENGTH
        );
    }
}
