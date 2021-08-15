package api.service.mapper.impl;

import api.domain.KhachHang;
import api.service.dto.KhachHangDTO;
import api.service.mapper.KhachHangMapper;
import api.web.rest.vm.ManagedUserVM;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class KhachHangMapperImpl implements KhachHangMapper {

    @Override
    public List<KhachHangDTO> fromModelToDtos(List<KhachHang> khachHangs) {
        return khachHangs.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public KhachHangDTO fromModelToDto(KhachHang khachHang) {
        if (khachHang == null) {
            return null;
        }

        return new KhachHangDTO(khachHang);
    }

    @Override
    public KhachHang fromDtoToModel(KhachHangDTO khachHangDTO) {
        if (khachHangDTO == null) {
            return null;
        }

        KhachHang khachHang = new KhachHang();

        khachHang.setUsername(khachHangDTO.getUsername());

        return khachHang;
    }

    @Override
    public List<KhachHang> fromDtoToModels(List<KhachHangDTO> khachHangDTOS) {
        return khachHangDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }

    @Override
    public KhachHang userFromUsername(String username) {
        KhachHang khachHang = new KhachHang();

        khachHang.setUsername(username);

        return khachHang;
    }

    @Override
    public KhachHangDTO toLoginUserDto(KhachHang khachHang) {
        if (khachHang == null) {
            return null;
        }

        KhachHangDTO khachHangDTO = new KhachHangDTO();

        khachHangDTO.setUsername(khachHang.getUsername());

        return khachHangDTO;
    }

    @Override
    public KhachHang managedUserVMToUser(ManagedUserVM managedUserVM) {
        if (managedUserVM == null) {
            return null;
        }

        KhachHang khachHang = new KhachHang();

        khachHang.setUsername(managedUserVM.getUsername());

        return khachHang;
    }
}
