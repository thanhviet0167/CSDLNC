package api.service.impl;

import api.repository.HinhThucVanChuyenRepository;
import api.service.HinhThucVanChuyenService;
import api.service.dto.HinhThucVanChuyenDTO;
import api.service.mapper.HinhThucVanChuyenMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HinhThucVanChuyenServiceImpl implements HinhThucVanChuyenService {

    private final HinhThucVanChuyenRepository hinhThucVanChuyenRepository;

    private final HinhThucVanChuyenMapper hinhThucVanChuyenMapper;

    public HinhThucVanChuyenServiceImpl(HinhThucVanChuyenRepository hinhThucVanChuyenRepository, HinhThucVanChuyenMapper hinhThucVanChuyenMapper) {
        this.hinhThucVanChuyenRepository = hinhThucVanChuyenRepository;
        this.hinhThucVanChuyenMapper = hinhThucVanChuyenMapper;
    }

    @Override
    public List<HinhThucVanChuyenDTO> findAll() {
        return hinhThucVanChuyenRepository.findAll().stream().map(hinhThucVanChuyenMapper::fromModelToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<HinhThucVanChuyenDTO> findOne(Long id) {
        return hinhThucVanChuyenRepository.findById(id).map(hinhThucVanChuyenMapper::fromModelToDto);
    }
}
