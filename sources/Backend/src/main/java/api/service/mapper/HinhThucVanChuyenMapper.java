package api.service.mapper;

import api.domain.HinhThucVanChuyen;
import api.service.dto.HinhThucVanChuyenDTO;

import java.util.List;

public interface HinhThucVanChuyenMapper {

    public List<HinhThucVanChuyenDTO> fromModelToDtos(List<HinhThucVanChuyen> hinhThucVanChuyens);

    public HinhThucVanChuyenDTO fromModelToDto(HinhThucVanChuyen hinhThucVanChuyen);

    public HinhThucVanChuyen fromDtoToModel(HinhThucVanChuyenDTO hinhThucVanChuyenDTO);

    public List<HinhThucVanChuyen> fromDtoToModels(List<HinhThucVanChuyenDTO> hinhThucVanChuyenDTOS);

}
