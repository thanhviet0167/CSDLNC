package api.service.mapper.impl;

import api.domain.TinhThanhPho;
import api.service.dto.TinhThanhPhoDTO;
import api.service.mapper.TinhThanhPhoMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TinhThanhPhoMapperImpl implements TinhThanhPhoMapper {
    @Override
    public List<TinhThanhPhoDTO> fromModelToDtos(List<TinhThanhPho> tinhThanhPhos) {
        return tinhThanhPhos.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TinhThanhPhoDTO fromModelToDto(TinhThanhPho tinhThanhPho) {
        if (tinhThanhPho == null) {
            return null;
        }

        return new TinhThanhPhoDTO(tinhThanhPho);
    }

    @Override
    public TinhThanhPho fromDtoToModel(TinhThanhPhoDTO tinhThanhPhoDTO) {
        if (tinhThanhPhoDTO == null) {
            return null;
        }

        TinhThanhPho tinhThanhPho = new TinhThanhPho();

        return tinhThanhPho;
    }

    @Override
    public List<TinhThanhPho> fromDtoToModels(List<TinhThanhPhoDTO> tinhThanhPhoDTOS) {
        return tinhThanhPhoDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
