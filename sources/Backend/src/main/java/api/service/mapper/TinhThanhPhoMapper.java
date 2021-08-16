package api.service.mapper;

import api.domain.TinhThanhPho;
import api.service.dto.TinhThanhPhoDTO;

import java.util.List;

public interface TinhThanhPhoMapper {

    public List<TinhThanhPhoDTO> fromModelToDtos(List<TinhThanhPho> tinhThanhPhos);

    public TinhThanhPhoDTO fromModelToDto(TinhThanhPho tinhThanhPho);

    public TinhThanhPho fromDtoToModel(TinhThanhPhoDTO tinhThanhPhoDTO);

    public List<TinhThanhPho> fromDtoToModels(List<TinhThanhPhoDTO> tinhThanhPhoDTOS);

}
