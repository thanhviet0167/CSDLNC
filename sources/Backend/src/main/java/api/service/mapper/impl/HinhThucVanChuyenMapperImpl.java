package api.service.mapper.impl;

import api.domain.HinhThucVanChuyen;
import api.service.dto.HinhThucVanChuyenDTO;
import api.service.mapper.HinhThucVanChuyenMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class HinhThucVanChuyenMapperImpl implements HinhThucVanChuyenMapper {
    @Override
    public List<HinhThucVanChuyenDTO> fromModelToDtos(List<HinhThucVanChuyen> hinhThucVanChuyens) {
        return hinhThucVanChuyens.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public HinhThucVanChuyenDTO fromModelToDto(HinhThucVanChuyen hinhThucVanChuyen) {
        if (hinhThucVanChuyen == null) {
            return null;
        }

        return new HinhThucVanChuyenDTO(hinhThucVanChuyen);
    }

    @Override
    public HinhThucVanChuyen fromDtoToModel(HinhThucVanChuyenDTO hinhThucVanChuyenDTO) {
        if (hinhThucVanChuyenDTO == null) {
            return null;
        }

        HinhThucVanChuyen hinhThucVanChuyen = new HinhThucVanChuyen();

        return hinhThucVanChuyen;
    }

    @Override
    public List<HinhThucVanChuyen> fromDtoToModels(List<HinhThucVanChuyenDTO> hinhThucVanChuyenDTOS) {
        return hinhThucVanChuyenDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
