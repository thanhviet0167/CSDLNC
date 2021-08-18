package api.service;

import api.domain.DonHang;

import java.util.List;
import java.util.Optional;

public interface DonHangService {
    List<DonHang> getAllByKhachHangAndStatus(String khachHang, Integer status);

    Optional<DonHang> getOne(Long id);
}
