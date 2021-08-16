package api.service.mapper;

import api.domain.BoSuuTap;
import api.service.dto.BoSuuTapDTO;

import java.util.List;

public interface BoSuuTapMapper {

    public List<BoSuuTapDTO> fromModelToDtos(List<BoSuuTap> boSuuTaps);

    public BoSuuTapDTO fromModelToDto(BoSuuTap boSuuTap);

    public BoSuuTap fromDtoToModel(BoSuuTapDTO boSuuTapDTO);

    public List<BoSuuTap> fromDtoToModels(List<BoSuuTapDTO> boSuuTapDTOS);

}
