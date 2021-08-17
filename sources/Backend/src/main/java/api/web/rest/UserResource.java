package api.web.rest;

import api.domain.KhachHang;
import api.security.JWTService;
import api.service.KhachHangService;
import api.service.dto.KhachHangDTO;
import api.service.mapper.KhachHangMapper;
import api.web.rest.errors.UsernameAlreadyUsedException;
import api.web.rest.vm.ManagedUserVM;
import api.web.rest.vm.ObjectPaginationVM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class UserResource {

    private static final List<String> ALLOWED_ORDERED_PROPERTIES = Collections.unmodifiableList(
            Arrays.asList(
                    "username",
                    "createdBy",
                    "createdDate",
                    "lastModifiedBy",
                    "lastModifiedDate"
            )
    );

    private final KhachHangService khachHangService;
    private final KhachHangMapper khachHangMapper;
    private final JWTService jwtService;

    public UserResource(
            KhachHangService khachHangService,
            KhachHangMapper khachHangMapper,
            JWTService jwtService
    ) {
        this.khachHangService = khachHangService;
        this.khachHangMapper = khachHangMapper;
        this.jwtService = jwtService;
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<KhachHang> getUserByUsername(
            HttpServletRequest request,
            @PathVariable String username
    ) {
//        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }

        Optional<KhachHang> userDtoOptional = khachHangService.getUser(username);

        if (!userDtoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDtoOptional.get());
    }

    @GetMapping("/users")
    public ResponseEntity<ObjectPaginationVM> getAllUsers(
            HttpServletRequest request,
            @RequestParam Pageable pageable
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (!onlyContainsAllowedProperties(pageable)) {
            return ResponseEntity.badRequest().build();
        }

        Page<KhachHang> page = khachHangService.getAllUsers(pageable);

        return ResponseEntity.ok(new ObjectPaginationVM(page));
    }

    @PostMapping("/users")
    public ResponseEntity<KhachHang> createUser(
            HttpServletRequest request,
            @RequestBody ManagedUserVM managedUserVM
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (isPasswordLengthInvalid(managedUserVM.getPassword())) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Optional<KhachHang> userDtoOptional = khachHangService.createUser(managedUserVM);

            if (userDtoOptional.isPresent()) {
                return ResponseEntity.ok(userDtoOptional.get());
            }
        } catch (UsernameAlreadyUsedException e) {
            e.printStackTrace();

        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/users")
    public ResponseEntity<KhachHang> updateUser(
            HttpServletRequest request,
            @RequestBody KhachHangDTO khachHangDto
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Optional<KhachHang> userDtoOptional = khachHangService.updateUser(khachHangMapper.fromDtoToModel(khachHangDto));

        if (!userDtoOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userDtoOptional.get());
    }

    @DeleteMapping("/users/{username}")
    public void deleteUser(
            HttpServletRequest request,
            @PathVariable String username
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return;
        }

        khachHangService.deleteUser(username);
    }

    private boolean onlyContainsAllowedProperties(Pageable pageable) {
        return pageable.getSort().stream().map(Sort.Order::getProperty).allMatch(ALLOWED_ORDERED_PROPERTIES::contains);
    }

    private static boolean isPasswordLengthInvalid(String password) {
        return (
                StringUtils.isEmpty(password) ||
                        password.length() < ManagedUserVM.PASSWORD_MIN_LENGTH ||
                        password.length() > ManagedUserVM.PASSWORD_MAX_LENGTH
        );
    }
}
