package api.service.mapper;

import api.domain.KhachHang;
import api.domain.NhanVien;
import api.service.dto.KhachHangDTO;
import api.service.dto.NhanVienDTO;

import java.util.List;

public interface NhanVienMapper {
    public List<NhanVienDTO> fromModelToDtos(List<NhanVien> nhanViens);

    public NhanVienDTO fromModelToDto(NhanVien nhanVien);

    public NhanVien fromDtoToModel(NhanVienDTO nhanVienDTO);

    public List<NhanVien> fromDtoToModels(List<NhanVienDTO> nhanVienDTOS);
}
