package api.web.rest;

import api.domain.BoSuuTap;
import api.domain.SanPham;
import api.security.JWTService;
import api.service.BoSuuTapService;
import api.service.NhaCungCapService;
import api.service.dto.NhaCungCapDTO;
import api.web.rest.vm.ObjectPaginationVM;
import api.web.rest.vm.RevenueStatisticsVM;
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
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NhaCungCapResource {

    private final JWTService jwtService;

    private final NhaCungCapService nhaCungCapService;

    private final BoSuuTapService boSuuTapService;

    public NhaCungCapResource(JWTService jwtService, NhaCungCapService nhaCungCapService,BoSuuTapService boSuuTapService) {
        this.jwtService = jwtService;
        this.nhaCungCapService = nhaCungCapService;
        this.boSuuTapService = boSuuTapService;
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<NhaCungCapDTO> get(
            HttpServletRequest request,
            @PathVariable String id
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

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
        Page<NhaCungCapDTO> nhaCungCapDTOPage = nhaCungCapService.findByKeyword(keyword, pageable);

        ObjectPaginationVM objectPaginationVM = new ObjectPaginationVM(nhaCungCapDTOPage);

        return ResponseEntity.ok(objectPaginationVM);
    }

    @GetMapping("/store/{store}/collection")
    public ResponseEntity<List<BoSuuTap>> getStoreCollection(
            HttpServletRequest request,
            @PathVariable String store
    ) {
        List<BoSuuTap> boSuuTapList = boSuuTapService.getStoreCollection(store);

        return ResponseEntity.ok(boSuuTapList);
    }

    @GetMapping("/store/{store}/collection/{stt}")
    public ResponseEntity<BoSuuTap> getCollection(
            HttpServletRequest request,
            @PathVariable String store,
            @PathVariable Integer stt
    ) {
        Optional<BoSuuTap> boSuuTapOptional = boSuuTapService.getCollection(store, stt);

        if (!boSuuTapOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(boSuuTapOptional.get());
    }

    @GetMapping("/store/{store}/statistics/revenue")
    public ResponseEntity<RevenueStatisticsVM> getRevenueStatistics(
            HttpServletRequest request,
            @PathVariable String store,
            @RequestParam String from,
            @RequestParam String to
    ) {
        if (!jwtService.validateToken(request.getHeader("Authorization"))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        RevenueStatisticsVM statisticsVM = nhaCungCapService.getRevenueStatistics(store, from, to);

        return ResponseEntity.ok(statisticsVM);
    }
}
