package api.web.rest;

import api.domain.SanPham;
import api.security.JWTService;
import api.service.NhaCungCapService;
import api.service.dto.NhaCungCapDTO;
import api.web.rest.vm.ObjectPaginationVM;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NhaCungCapResource {

    private final JWTService jwtService;

    private final NhaCungCapService nhaCungCapService;

    public NhaCungCapResource(JWTService jwtService, NhaCungCapService nhaCungCapService) {
        this.jwtService = jwtService;
        this.nhaCungCapService = nhaCungCapService;
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<NhaCungCapDTO> get(
            HttpServletRequest request,
            @PathVariable String id
    ) {
//        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }

        Optional<NhaCungCapDTO> sanPhamOptional = nhaCungCapService.findOne(id);

        if (!sanPhamOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sanPhamOptional.get());
    }

    @GetMapping("/store/search")
    public ResponseEntity<ObjectPaginationVM> search(
            HttpServletRequest request,
            @RequestParam String keyword,
            Pageable pageable
    ) {
//        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }

        Page<NhaCungCapDTO> nhaCungCapDTOPage = nhaCungCapService.findByKeyword(keyword, pageable);

        ObjectPaginationVM objectPaginationVM = new ObjectPaginationVM(nhaCungCapDTOPage);

        return ResponseEntity.ok(objectPaginationVM);

//        try {
//            String bodyContent = objectMapper.writeValueAsString(objectPaginationVM);
//            return ResponseEntity.ok(bodyContent);
//        } catch (JsonProcessingException ignored) {
//            ignored.printStackTrace();
//            return ResponseEntity.notFound().build();
//        }

    }
}
