package api.web.rest;

import api.domain.HinhThucVanChuyen;
import api.service.HinhThucVanChuyenService;
import api.service.dto.HinhThucVanChuyenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HinhThucVanChuyenResource {

    private HinhThucVanChuyenService hinhThucVanChuyenService;

    public HinhThucVanChuyenResource(HinhThucVanChuyenService hinhThucVanChuyenService) {
        this.hinhThucVanChuyenService = hinhThucVanChuyenService;
    }

    @GetMapping("/transport-method")
    public ResponseEntity<List<HinhThucVanChuyenDTO>> findAll(){
        List<HinhThucVanChuyenDTO> hinhThucVanChuyenList = hinhThucVanChuyenService.findAll();

        return ResponseEntity.ok(hinhThucVanChuyenList);
    }

    @GetMapping("/transport-method/{id}")
    public ResponseEntity<HinhThucVanChuyenDTO> findOne(
            @PathVariable Long id
    ){
        Optional<HinhThucVanChuyenDTO> hinhThucVanChuyenDTOOptional = hinhThucVanChuyenService.findOne(id);

        if (!hinhThucVanChuyenDTOOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(hinhThucVanChuyenDTOOptional.get());
    }
}
