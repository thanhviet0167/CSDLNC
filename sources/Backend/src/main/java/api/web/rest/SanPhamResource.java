package api.web.rest;

import api.domain.SanPham;
import api.security.JWTService;
import api.service.SanPhamService;
import api.service.dto.NhaCungCapDTO;
import api.web.rest.vm.ObjectPaginationVM;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SanPhamResource {

    private final JWTService jwtService;
    private final SanPhamService sanPhamService;

    public SanPhamResource(JWTService jwtService, SanPhamService sanPhamService) {
        this.jwtService = jwtService;
        this.sanPhamService = sanPhamService;
    }

    @GetMapping("/product/search")
    public ResponseEntity<ObjectPaginationVM> searchWithCondition(
            HttpServletRequest request,
            @RequestParam String query,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sort
//            Pageable pageable
    ) {
//        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }

        Map<String, String> queryParams = new HashMap<>();
        String[] querySplit = query.split("&");

        for (String str : querySplit) {
            String[] strs = str.split("=");
            if (strs.length == 2) {
                queryParams.put(strs[0],strs[1]);
            }
        }

        ObjectPaginationVM sanPhamPage = sanPhamService.searchWithCondition(queryParams, page, size, sort);

//        return ResponseEntity.ok(new ObjectPaginationVM(sanPhamPage));

        return ResponseEntity.ok(sanPhamPage);

//        return ResponseEntity.ok(sanPhamService.searchWithCondition(queryParams, page, pageSize, sort));
    }

    @GetMapping("/product/all")
    public ResponseEntity<ObjectPaginationVM> searchAll(
            HttpServletRequest request,
            Pageable pageable
    ) {
//        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }

        Page<SanPham> nhaCungCapDTOPage = sanPhamService.searchAll(pageable);

        ObjectPaginationVM objectPaginationVM = new ObjectPaginationVM(nhaCungCapDTOPage);

        return ResponseEntity.ok(objectPaginationVM);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<SanPham> get(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
//        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }

        Optional<SanPham> sanPhamOptional = sanPhamService.get(id);

        if (!sanPhamOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sanPhamOptional.get());
    }
}
