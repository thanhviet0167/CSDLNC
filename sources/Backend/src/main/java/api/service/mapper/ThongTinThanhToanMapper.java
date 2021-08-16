package api.service.mapper;

import api.domain.ThongTinThanhToan;
import api.service.dto.ThongTinThanhToanDTO;

import java.util.List;

public interface ThongTinThanhToanMapper {

    public List<ThongTinThanhToanDTO> fromModelToDtos(List<ThongTinThanhToan> thongTinThanhToans);

    public ThongTinThanhToanDTO fromModelToDto(ThongTinThanhToan thongTinThanhToan);

    public ThongTinThanhToan fromDtoToModel(ThongTinThanhToanDTO thongTinThanhToanDTO);

    public List<ThongTinThanhToan> fromDtoToModels(List<ThongTinThanhToanDTO> thongTinThanhToanDTOS);

}
