package api.service;

import api.domain.GioHang;

import java.util.List;
import java.util.Optional;

public interface GioHangService {
    List<GioHang> findAllCartNotOrder(String username);

    Optional<GioHang> findOne(Long maGioHang);

    void delete(Long maGioHang);
}
