package api.service.mapper;

import api.domain.DonHang;
import api.domain.DonHang;
import api.service.dto.DonHangDTO;

import java.util.List;

public interface DonHangMapper {

    public List<DonHangDTO> fromModelToDtos(List<DonHang> donHangs);

    public DonHangDTO fromModelToDto(DonHang donHang);

    public DonHang fromDtoToModel(DonHangDTO donHangDTO);

    public List<DonHang> fromDtoToModels(List<DonHangDTO> donHangDTOS);

}
