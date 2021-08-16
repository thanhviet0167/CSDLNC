package api.service.mapper.impl;

import api.domain.DanhMuc;
import api.domain.NhanVien;
import api.service.dto.DanhMucDTO;
import api.service.dto.NhanVienDTO;
import api.service.mapper.DanhMucMapper;
import api.service.mapper.NhanVienMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DanhMucMapperImpl implements DanhMucMapper {
    @Override
    public List<DanhMucDTO> fromModelToDtos(List<DanhMuc> danhMucs) {
        return danhMucs.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DanhMucDTO fromModelToDto(DanhMuc danhMuc) {
        if (danhMuc == null) {
            return null;
        }

        return new DanhMucDTO(danhMuc);
    }

    @Override
    public DanhMuc fromDtoToModel(DanhMucDTO danhMucDTO) {
        if (danhMucDTO == null) {
            return null;
        }

        DanhMuc danhMuc = new DanhMuc();

        return danhMuc;
    }

    @Override
    public List<DanhMuc> fromDtoToModels(List<DanhMucDTO> danhMucDTOS) {
        return danhMucDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
