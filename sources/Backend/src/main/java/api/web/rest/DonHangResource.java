package api.web.rest;

import api.domain.DonHang;
import api.domain.KhachHang;
import api.security.JWTService;
import api.service.DonHangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DonHangResource {

    private final JWTService jwtService;
    private final DonHangService donHangService;

    public DonHangResource(JWTService jwtService, DonHangService donHangService) {
        this.jwtService = jwtService;
        this.donHangService = donHangService;
    }

    @GetMapping("/order")
    public ResponseEntity<List<DonHang>> getKhachHangDonHang(
            HttpServletRequest request,
            @RequestParam(required = false) Integer status
    ) {
        String token = request.getHeader("Authorization");

        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        KhachHang khachHang = jwtService.getAuthentication(token);

        List<DonHang> donHangList = donHangService.getAllByKhachHangAndStatus(khachHang.getUsername(), status);

        return ResponseEntity.ok(donHangList);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<DonHang> getDonHang(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        String token = request.getHeader("Authorization");

        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Optional<DonHang> donHangOptional = donHangService.getOne(id);

        if (!donHangOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(donHangOptional.get());
    }

}
