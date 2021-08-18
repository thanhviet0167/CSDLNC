package api.service.impl;

import api.domain.DonHang;
import api.repository.DonHangRepository;
import api.service.DonHangService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonHangServiceImpl implements DonHangService {

    private final DonHangRepository donHangRepository;

    public DonHangServiceImpl(DonHangRepository donHangRepository) {
        this.donHangRepository = donHangRepository;
    }

    @Override
    public List<DonHang> getAllByKhachHangAndStatus(String khachHang, Integer status) {
        return donHangRepository.findAllByKhachHang(khachHang, status);
    }

    @Override
    public Optional<DonHang> getOne(Long id) {
        return donHangRepository.findById(id);
    }
}
