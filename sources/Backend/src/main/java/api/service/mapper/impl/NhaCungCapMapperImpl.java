package api.service.mapper.impl;

import api.domain.NhaCungCap;
import api.service.dto.NhaCungCapDTO;
import api.service.mapper.NhaCungCapMapper;
import api.service.mapper.TinhThanhPhoMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NhaCungCapMapperImpl implements NhaCungCapMapper {
    private final TinhThanhPhoMapper tinhThanhPhoMapper;
    @Override
    public List<NhaCungCapDTO> fromModelToDtos(List<NhaCungCap> nhaCungCaps) {
        return nhaCungCaps.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public NhaCungCapDTO fromModelToDto(NhaCungCap nhaCungCap) {
        if (nhaCungCap == null) {
            return null;
        }

        return new NhaCungCapDTO(nhaCungCap, tinhThanhPhoMapper);
    }

    @Override
    public NhaCungCap fromDtoToModel(NhaCungCapDTO nhaCungCapDTO) {
        if (nhaCungCapDTO == null) {
            return null;
        }

        NhaCungCap nhaCungCap = new NhaCungCap();

        return nhaCungCap;
    }

    @Override
    public List<NhaCungCap> fromDtoToModels(List<NhaCungCapDTO> nhaCungCapDTOS) {
        return nhaCungCapDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
