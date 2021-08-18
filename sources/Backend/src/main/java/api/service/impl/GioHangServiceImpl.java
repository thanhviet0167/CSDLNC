package api.service.impl;

import api.domain.GioHang;
import api.domain.KhachHang;
import api.repository.GioHangRepository;
import api.service.GioHangService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GioHangServiceImpl implements GioHangService {

    private final GioHangRepository gioHangRepository;

    public GioHangServiceImpl(GioHangRepository gioHangRepository) {
        this.gioHangRepository = gioHangRepository;
    }

    @Override
    public List<GioHang> findAllCartNotOrder(String khachHang) {

        return gioHangRepository.findAllByKhachHangAndTrangThaiDatHang(khachHang, 0);
    }

    @Override
    public Optional<GioHang> findOne(Long maGioHang) {
        return gioHangRepository.findByMaGioHang(maGioHang);
    }

    @Override
    public void delete(Long maGioHang) {
        gioHangRepository.deleteById(maGioHang);
    }
}
