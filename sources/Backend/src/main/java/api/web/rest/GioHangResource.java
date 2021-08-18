package api.web.rest;

import api.domain.GioHang;
import api.domain.KhachHang;
import api.security.JWTService;
import api.service.GioHangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GioHangResource {

    private final JWTService jwtService;

    private final GioHangService gioHangService;

    public GioHangResource(JWTService jwtService, GioHangService gioHangService) {
        this.jwtService = jwtService;
        this.gioHangService = gioHangService;
    }

    @GetMapping("/cart")
    public ResponseEntity<List<GioHang>> findAllCartNotOrder(
            HttpServletRequest request
    ) {
        String token = request.getHeader("Authorization");

        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        KhachHang khachHang = jwtService.getAuthentication(token);
        List<GioHang> gioHangList = gioHangService.findAllCartNotOrder(khachHang.getUsername());

        return ResponseEntity.ok(gioHangList);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<GioHang> findOne(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        String token = request.getHeader("Authorization");

        if (!jwtService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Optional<GioHang> gioHangOptional = gioHangService.findOne(id);

        if (!gioHangOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(gioHangOptional.get());
    }

    @DeleteMapping("/cart/{id}")
    public void delete(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        gioHangService.delete(id);
    }
}
