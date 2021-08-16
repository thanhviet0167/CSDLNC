package api.service.mapper.impl;

import api.domain.DanhMucSanPham;
import api.service.dto.DanhMucSanPhamDTO;
import api.service.mapper.DanhMucMapper;
import api.service.mapper.DanhMucSanPhamMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DanhMucSanPhamMapperImpl implements DanhMucSanPhamMapper {
    private final DanhMucMapper danhMucMapper;

    public DanhMucSanPhamMapperImpl(DanhMucMapper danhMucMapper) {
        this.danhMucMapper = danhMucMapper;
    }

    @Override
    public List<DanhMucSanPhamDTO> fromModelToDtos(List<DanhMucSanPham> danhMucSanPhams) {
        return danhMucSanPhams.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DanhMucSanPhamDTO fromModelToDto(DanhMucSanPham danhMucSanPham) {
        if (danhMucSanPham == null) {
            return null;
        }

        return new DanhMucSanPhamDTO(danhMucSanPham,  danhMucMapper);
    }

    @Override
    public DanhMucSanPham fromDtoToModel(DanhMucSanPhamDTO danhMucSanPhamDTO) {
        if (danhMucSanPhamDTO == null) {
            return null;
        }

        DanhMucSanPham danhMucSanPham = new DanhMucSanPham();

        return danhMucSanPham;
    }

    @Override
    public List<DanhMucSanPham> fromDtoToModels(List<DanhMucSanPhamDTO> danhMucSanPhamDTOS) {
        return danhMucSanPhamDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
