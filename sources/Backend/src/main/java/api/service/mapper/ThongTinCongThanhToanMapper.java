package api.service.mapper;

import api.domain.ThongTinCongThanhToan;
import api.service.dto.ThongTinCongThanhToanDTO;

import java.util.List;

public interface ThongTinCongThanhToanMapper {

    public List<ThongTinCongThanhToanDTO> fromModelToDtos(List<ThongTinCongThanhToan> danhMucs);

    public ThongTinCongThanhToanDTO fromModelToDto(ThongTinCongThanhToan danhMuc);

    public ThongTinCongThanhToan fromDtoToModel(ThongTinCongThanhToanDTO danhMucDTO);

    public List<ThongTinCongThanhToan> fromDtoToModels(List<ThongTinCongThanhToanDTO> danhMucDTOS);

}
