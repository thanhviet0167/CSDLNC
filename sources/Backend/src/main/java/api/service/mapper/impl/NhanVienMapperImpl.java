package api.service.mapper.impl;

import api.domain.KhachHang;
import api.domain.NhanVien;
import api.service.dto.KhachHangDTO;
import api.service.dto.NhanVienDTO;
import api.service.mapper.NhanVienMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class NhanVienMapperImpl implements NhanVienMapper {

    @Override
    public List<NhanVienDTO> fromModelToDtos(List<NhanVien> nhanViens) {
        return nhanViens.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public NhanVienDTO fromModelToDto(NhanVien nhanVien) {
        if (nhanVien == null) {
            return null;
        }

        return new NhanVienDTO(nhanVien);
    }

    @Override
    public NhanVien fromDtoToModel(NhanVienDTO nhanVienDTO) {
        if (nhanVienDTO == null) {
            return null;
        }

        NhanVien nhanVien = new NhanVien();

        return nhanVien;
    }

    @Override
    public List<NhanVien> fromDtoToModels(List<NhanVienDTO> nhanVienDTOS) {
        return nhanVienDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
