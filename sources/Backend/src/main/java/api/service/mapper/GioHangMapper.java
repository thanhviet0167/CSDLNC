package api.service.mapper;

import api.domain.GioHang;
import api.service.dto.GioHangDTO;

import java.util.List;

public interface GioHangMapper {

    public List<GioHangDTO> fromModelToDtos(List<GioHang> gioHangs);

    public GioHangDTO fromModelToDto(GioHang gioHang);

    public GioHang fromDtoToModel(GioHangDTO gioHangDTO);

    public List<GioHang> fromDtoToModels(List<GioHangDTO> gioHangDTOS);

}
