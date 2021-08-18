package api.web.rest;

import api.domain.HinhThucVanChuyen;
import api.service.HinhThucVanChuyenService;
import api.service.dto.HinhThucVanChuyenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
