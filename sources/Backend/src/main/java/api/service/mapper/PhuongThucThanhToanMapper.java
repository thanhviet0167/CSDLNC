package api.service.mapper;

import api.domain.PhuongThucThanhToan;
import api.service.dto.PhuongThucThanhToanDTO;

import java.util.List;

public interface PhuongThucThanhToanMapper {

    public List<PhuongThucThanhToanDTO> fromModelToDtos(List<PhuongThucThanhToan> phuongThucThanhToans);

    public PhuongThucThanhToanDTO fromModelToDto(PhuongThucThanhToan phuongThucThanhToan);

    public PhuongThucThanhToan fromDtoToModel(PhuongThucThanhToanDTO phuongThucThanhToanDTO);

    public List<PhuongThucThanhToan> fromDtoToModels(List<PhuongThucThanhToanDTO> phuongThucThanhToanDTOS);

}
