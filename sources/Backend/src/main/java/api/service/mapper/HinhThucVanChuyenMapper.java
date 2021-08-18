package api.service.mapper;

import api.domain.HinhThucVanChuyen;
import api.service.dto.HinhThucVanChuyenDTO;

import java.util.List;
import java.util.Set;

public interface HinhThucVanChuyenMapper {

    List<HinhThucVanChuyenDTO> fromModelToDtos(List<HinhThucVanChuyen> hinhThucVanChuyens);

    HinhThucVanChuyenDTO fromModelToDto(HinhThucVanChuyen hinhThucVanChuyen);

    HinhThucVanChuyen fromDtoToModel(HinhThucVanChuyenDTO hinhThucVanChuyenDTO);

    List<HinhThucVanChuyen> fromDtoToModels(List<HinhThucVanChuyenDTO> hinhThucVanChuyenDTOS);

    Set<HinhThucVanChuyenDTO> fromModelToDtoSet(Set<HinhThucVanChuyen> hinhThucVanChuyenSet);

    Set<HinhThucVanChuyen> fromDtoToModelSet(Set<HinhThucVanChuyenDTO> hinhThucVanChuyenDtoSet);
}
