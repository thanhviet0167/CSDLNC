package api.service.mapper;

import api.domain.SoDiaChi;
import api.service.dto.SoDiaChiDTO;

import java.util.List;

public interface SoDiaChiMapper {

    public List<SoDiaChiDTO> fromModelToDtos(List<SoDiaChi> soDiaChis);

    public SoDiaChiDTO fromModelToDto(SoDiaChi soDiaChi);

    public SoDiaChi fromDtoToModel(SoDiaChiDTO soDiaChiDTO);

    public List<SoDiaChi> fromDtoToModels(List<SoDiaChiDTO> soDiaChiDTOS);

}
