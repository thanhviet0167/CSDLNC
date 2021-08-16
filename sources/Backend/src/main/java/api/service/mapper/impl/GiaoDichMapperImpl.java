package api.service.mapper.impl;

import api.domain.GiaoDich;
import api.service.dto.GiaoDichDTO;
import api.service.mapper.GiaoDichMapper;
import api.service.mapper.PhuongThucThanhToanMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GiaoDichMapperImpl implements GiaoDichMapper {
    private final PhuongThucThanhToanMapper phuongThucThanhToanMapper;

    public GiaoDichMapperImpl(PhuongThucThanhToanMapper phuongThucThanhToanMapper) {
        this.phuongThucThanhToanMapper = phuongThucThanhToanMapper;
    }

    @Override
    public List<GiaoDichDTO> fromModelToDtos(List<GiaoDich> giaoDichs) {
        return giaoDichs.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GiaoDichDTO fromModelToDto(GiaoDich giaoDich) {
        if (giaoDich == null) {
            return null;
        }

        return new GiaoDichDTO(giaoDich, phuongThucThanhToanMapper);
    }

    @Override
    public GiaoDich fromDtoToModel(GiaoDichDTO giaoDichDTO) {
        if (giaoDichDTO == null) {
            return null;
        }

        GiaoDich giaoDich = new GiaoDich();

        return giaoDich;
    }

    @Override
    public List<GiaoDich> fromDtoToModels(List<GiaoDichDTO> giaoDichDTOS) {
        return giaoDichDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
