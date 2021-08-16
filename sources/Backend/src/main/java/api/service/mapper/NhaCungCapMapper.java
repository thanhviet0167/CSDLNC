package api.service.mapper;

import api.domain.NhaCungCap;
import api.service.dto.NhaCungCapDTO;

import java.util.List;

public interface NhaCungCapMapper {

    public List<NhaCungCapDTO> fromModelToDtos(List<NhaCungCap> nhaCungCaps);

    public NhaCungCapDTO fromModelToDto(NhaCungCap nhaCungCap);

    public NhaCungCap fromDtoToModel(NhaCungCapDTO nhaCungCapDTO);

    public List<NhaCungCap> fromDtoToModels(List<NhaCungCapDTO> nhaCungCapDTOS);

}
