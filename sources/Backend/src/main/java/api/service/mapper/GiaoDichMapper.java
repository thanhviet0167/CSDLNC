package api.service.mapper;

import api.domain.GiaoDich;
import api.service.dto.GiaoDichDTO;

import java.util.List;

public interface GiaoDichMapper {

    public List<GiaoDichDTO> fromModelToDtos(List<GiaoDich> giaoDichs);

    public GiaoDichDTO fromModelToDto(GiaoDich giaoDich);

    public GiaoDich fromDtoToModel(GiaoDichDTO giaoDichDTO);

    public List<GiaoDich> fromDtoToModels(List<GiaoDichDTO> giaoDichDTOS);

}
