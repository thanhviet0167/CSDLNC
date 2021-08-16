package api.service.mapper.impl;

import api.domain.BoSuuTap;
import api.service.dto.BoSuuTapDTO;
import api.service.mapper.BoSuuTapMapper;
import api.service.mapper.NhaCungCapMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BoSuuTapMapperImpl implements BoSuuTapMapper {
    private NhaCungCapMapper nhaCungCapMapper;

    public BoSuuTapMapperImpl(NhaCungCapMapper nhaCungCapMapper) {
        this.nhaCungCapMapper = nhaCungCapMapper;
    }

    @Override
    public List<BoSuuTapDTO> fromModelToDtos(List<BoSuuTap> boSuuTaps) {
        return boSuuTaps.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BoSuuTapDTO fromModelToDto(BoSuuTap boSuuTap) {
        if (boSuuTap == null) {
            return null;
        }

        return new BoSuuTapDTO(boSuuTap,  nhaCungCapMapper);
    }

    @Override
    public BoSuuTap fromDtoToModel(BoSuuTapDTO boSuuTapDTO) {
        if (boSuuTapDTO == null) {
            return null;
        }

        BoSuuTap boSuuTap = new BoSuuTap();

        return boSuuTap;
    }

    @Override
    public List<BoSuuTap> fromDtoToModels(List<BoSuuTapDTO> boSuuTapDTOS) {
        return boSuuTapDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
