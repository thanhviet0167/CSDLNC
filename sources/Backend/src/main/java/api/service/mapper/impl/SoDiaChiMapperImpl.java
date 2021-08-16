package api.service.mapper.impl;

import api.domain.KhachHang;
import api.domain.SoDiaChi;
import api.service.dto.SoDiaChiDTO;
import api.service.mapper.KhachHangMapper;
import api.service.mapper.SoDiaChiMapper;
import api.service.mapper.TinhThanhPhoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class SoDiaChiMapperImpl implements SoDiaChiMapper {
    private final KhachHangMapper khachHangMapper;
    private final TinhThanhPhoMapper tinhThanhPhoMapper;

    public SoDiaChiMapperImpl(KhachHangMapper khachHangMapper, TinhThanhPhoMapper tinhThanhPhoMapper) {
        this.khachHangMapper = khachHangMapper;
        this.tinhThanhPhoMapper = tinhThanhPhoMapper;
    }

    @Override
    public List<SoDiaChiDTO> fromModelToDtos(List<SoDiaChi> soDiaChis) {
        return soDiaChis.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SoDiaChiDTO fromModelToDto(SoDiaChi soDiaChi) {
        if (soDiaChi == null) {
            return null;
        }

        return new SoDiaChiDTO( soDiaChi,  khachHangMapper,  tinhThanhPhoMapper);
    }

    @Override
    public SoDiaChi fromDtoToModel(SoDiaChiDTO soDiaChiDTO) {
        if (soDiaChiDTO == null) {
            return null;
        }

        SoDiaChi soDiaChi = new SoDiaChi();

        return soDiaChi;
    }

    @Override
    public List<SoDiaChi> fromDtoToModels(List<SoDiaChiDTO> soDiaChiDTOS) {
        return soDiaChiDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
