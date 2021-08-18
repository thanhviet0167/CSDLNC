package api.service.mapper;

import api.domain.HinhThucVanChuyen;
import api.domain.ThongTinHinhThucVanChuyen;
import api.service.dto.HinhThucVanChuyenDTO;
import api.service.dto.ThongTinHinhThucVanChuyenDTO;

import java.util.List;
import java.util.Set;

public interface ThongTinHinhThucVanChuyenMapper {


    List<ThongTinHinhThucVanChuyenDTO> fromModelToDtos(List<ThongTinHinhThucVanChuyen> thongTinHinhThucVanChuyens);

    ThongTinHinhThucVanChuyenDTO fromModelToDto(ThongTinHinhThucVanChuyen thongTinHinhThucVanChuyen);

    ThongTinHinhThucVanChuyen fromDtoToModel(ThongTinHinhThucVanChuyenDTO thongTinHinhThucVanChuyenDTO);

    List<ThongTinHinhThucVanChuyen> fromDtoToModels(List<ThongTinHinhThucVanChuyenDTO> thongTinHinhThucVanChuyenDTOS);

    Set<ThongTinHinhThucVanChuyenDTO> fromModelToDtoSet(Set<ThongTinHinhThucVanChuyen> thongTinHinhThucVanChuyenSet);

    Set<ThongTinHinhThucVanChuyen> fromDtoToModelSet(Set<ThongTinHinhThucVanChuyenDTO> thongTinHinhThucVanChuyenDTOSet);

}
