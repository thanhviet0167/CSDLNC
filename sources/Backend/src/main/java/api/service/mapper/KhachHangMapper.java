package api.service.mapper;

import api.domain.KhachHang;
import api.service.dto.KhachHangDTO;
import api.web.rest.vm.ManagedUserVM;

import java.util.List;

public interface KhachHangMapper {

    public List<KhachHangDTO> fromModelToDtos(List<KhachHang> khachHangs);

    public KhachHangDTO fromModelToDto(KhachHang khachHang);

    public KhachHang fromDtoToModel(KhachHangDTO khachHangDTO);

    public List<KhachHang> fromDtoToModels(List<KhachHangDTO> khachHangDTOS);

    public KhachHang userFromUsername(String username);

    public KhachHangDTO toLoginUserDto(KhachHang khachHang);

    public KhachHang managedUserVMToUser(ManagedUserVM managedUserVM);
}
