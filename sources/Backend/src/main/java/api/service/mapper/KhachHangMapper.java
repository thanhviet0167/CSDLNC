package api.service.mapper;

import api.domain.KhachHang;
import api.service.dto.KhachHangDTO;
import api.web.rest.vm.ManagedUserVM;

import java.util.List;

public interface KhachHangMapper {

    public List<KhachHangDTO> toUserDtos(List<KhachHang> khachHangs);

    public KhachHangDTO toUserDto(KhachHang khachHang);

    public KhachHang toUser(KhachHangDTO khachHangDTO);

    public List<KhachHang> toUsers(List<KhachHangDTO> khachHangDTOS);

    public KhachHang userFromUsername(String username);

    public KhachHangDTO toLoginUserDto(KhachHang khachHang);

    public KhachHang managedUserVMToUser(ManagedUserVM managedUserVM);
}
