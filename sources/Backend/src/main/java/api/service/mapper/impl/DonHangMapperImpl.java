package api.service.mapper.impl;

import api.domain.DonHang;
import api.service.dto.DonHangDTO;
import api.service.mapper.DonHangMapper;
import api.service.mapper.GiaoDichMapper;
import api.service.mapper.GioHangMapper;
import api.service.mapper.HinhThucVanChuyenMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DonHangMapperImpl implements DonHangMapper {
    private final GioHangMapper gioHangMapper;
    private final GiaoDichMapper giaoDichMapper;
    private final HinhThucVanChuyenMapper hinhThucVanChuyenMapper;

    public DonHangMapperImpl(GioHangMapper gioHangMapper, GiaoDichMapper giaoDichMapper, HinhThucVanChuyenMapper hinhThucVanChuyenMapper) {
        this.gioHangMapper = gioHangMapper;
        this.giaoDichMapper = giaoDichMapper;
        this.hinhThucVanChuyenMapper = hinhThucVanChuyenMapper;
    }

    @Override
    public List<DonHangDTO> fromModelToDtos(List<DonHang> donHangs) {
        return donHangs.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DonHangDTO fromModelToDto(DonHang donHang) {
        if (donHang == null) {
            return null;
        }

        return new DonHangDTO( donHang, gioHangMapper,  giaoDichMapper,  hinhThucVanChuyenMapper);
    }

    @Override
    public DonHang fromDtoToModel(DonHangDTO donHangDTO) {
        if (donHangDTO == null) {
            return null;
        }

        DonHang donHang = new DonHang();

        return donHang;
    }

    @Override
    public List<DonHang> fromDtoToModels(List<DonHangDTO> donHangDTOS) {
        return donHangDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
