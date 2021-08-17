package api.service.mapper;

import api.domain.BoSuuTap;
import api.domain.SanPham;
import api.service.dto.BoSuuTapDTO;
import api.service.dto.SanPhamDTO;

import java.util.List;

public interface SanPhamMapper {

    public List<SanPhamDTO> fromModelToDtos(List<SanPham> sanPhams);

    public SanPhamDTO fromModelToDto(SanPham sanPham);

    public SanPhamDTO fromModelToSearchDto(SanPham sanPham);

    public SanPham fromDtoToModel(SanPhamDTO sanPhamDTO);

    public List<SanPham> fromDtoToModels(List<SanPhamDTO> sanPhamDTOS);

}
