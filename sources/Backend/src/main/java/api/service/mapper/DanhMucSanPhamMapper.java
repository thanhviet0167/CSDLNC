package api.service.mapper;

import api.domain.DanhMucSanPham;
import api.service.dto.DanhMucSanPhamDTO;

import java.util.List;

public interface DanhMucSanPhamMapper {

    public List<DanhMucSanPhamDTO> fromModelToDtos(List<DanhMucSanPham> danhMucSanPhams);

    public DanhMucSanPhamDTO fromModelToDto(DanhMucSanPham danhMucSanPham);

    public DanhMucSanPham fromDtoToModel(DanhMucSanPhamDTO danhMucSanPhamDTO);

    public List<DanhMucSanPham> fromDtoToModels(List<DanhMucSanPhamDTO> danhMucSanPhamDTOS);

}
