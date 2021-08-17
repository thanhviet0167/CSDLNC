package api.service.mapper.impl;

import api.domain.GioHang;
import api.service.dto.GioHangDTO;
import api.service.mapper.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GioHangMapperImpl implements GioHangMapper {
    private final KhachHangMapper khachHangMapper;
    private final NhaCungCapMapper nhaCungCapMapper;
    private final VoucherMapper voucherMapper;
    private final SoDiaChiMapper soDiaChiMapper;

    public GioHangMapperImpl(KhachHangMapper khachHangMapper, NhaCungCapMapper nhaCungCapMapper, VoucherMapper voucherMapper, SoDiaChiMapper soDiaChiMapper) {
        this.khachHangMapper = khachHangMapper;
        this.nhaCungCapMapper = nhaCungCapMapper;
        this.voucherMapper = voucherMapper;
        this.soDiaChiMapper = soDiaChiMapper;
    }

    @Override
    public List<GioHangDTO> fromModelToDtos(List<GioHang> gioHangs) {
        return gioHangs.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GioHangDTO fromModelToDto(GioHang gioHang) {
        if (gioHang == null) {
            return null;
        }

        return new GioHangDTO( gioHang,  khachHangMapper,  nhaCungCapMapper,  voucherMapper,  soDiaChiMapper);
    }

    @Override
    public GioHang fromDtoToModel(GioHangDTO gioHangDTO) {
        if (gioHangDTO == null) {
            return null;
        }

        GioHang gioHang = new GioHang();

        return gioHang;
    }

    @Override
    public List<GioHang> fromDtoToModels(List<GioHangDTO> gioHangDTOS) {
        return gioHangDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
