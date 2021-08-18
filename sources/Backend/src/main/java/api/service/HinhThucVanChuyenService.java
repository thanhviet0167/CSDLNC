package api.service;

import api.service.dto.HinhThucVanChuyenDTO;

import java.util.List;
import java.util.Optional;

public interface HinhThucVanChuyenService {
    List<HinhThucVanChuyenDTO> findAll();

    Optional<HinhThucVanChuyenDTO> findOne(Long id);
}
