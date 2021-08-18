package api.web.rest;

import api.domain.KhachHang;
import api.domain.SoDiaChi;
import api.repository.KhachHangRepository;
import api.repository.SoDiaChiRepository;
import api.security.JWTService;
import api.service.KhachHangService;
import api.service.NhaCungCapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final JWTService jwtService;

    private final KhachHangService khachHangService;

    private final NhaCungCapService nhaCungCapService;

    public UserResource(JWTService jwtService, KhachHangService khachHangService, NhaCungCapService nhaCungCapService) {
        this.jwtService = jwtService;
        this.khachHangService = khachHangService;
        this.nhaCungCapService = nhaCungCapService;
    }

    @GetMapping("/user/address-note")
    public ResponseEntity<List<SoDiaChi>> findAllSoDiaChiKhachHang(
            HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");

        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        KhachHang khachHang = jwtService.getAuthentication(token);
        List<SoDiaChi> soDiaChiList = khachHangService.getAllKhachHangSoDiaChi(khachHang.getUsername());

        return ResponseEntity.ok(soDiaChiList);
    }
}
