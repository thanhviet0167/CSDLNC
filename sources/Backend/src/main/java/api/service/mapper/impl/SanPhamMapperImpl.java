package api.service.mapper.impl;

import api.domain.BoSuuTap;
import api.domain.DanhMucSanPham;
import api.domain.SanPham;
import api.service.dto.BoSuuTapDTO;
import api.service.dto.SanPhamDTO;
import api.service.mapper.BoSuuTapMapper;
import api.service.mapper.DanhMucSanPhamMapper;
import api.service.mapper.NhaCungCapMapper;
import api.service.mapper.SanPhamMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SanPhamMapperImpl implements SanPhamMapper {
    private final NhaCungCapMapper nhaCungCapMapper;
    private final DanhMucSanPhamMapper danhMucSanPhamMapper;
    private final BoSuuTapMapper boSuuTapMapper;

    public SanPhamMapperImpl(NhaCungCapMapper nhaCungCapMapper, DanhMucSanPhamMapper danhMucSanPhamMapper, BoSuuTapMapper boSuuTapMapper) {
        this.nhaCungCapMapper = nhaCungCapMapper;
        this.danhMucSanPhamMapper = danhMucSanPhamMapper;
        this.boSuuTapMapper = boSuuTapMapper;
    }

    @Override
    public List<SanPhamDTO> fromModelToDtos(List<SanPham> sanPhams) {
        return sanPhams.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SanPhamDTO fromModelToDto(SanPham sanPham) {
        if (sanPham == null) {
            return null;
        }

        return new SanPhamDTO(sanPham,  nhaCungCapMapper,  danhMucSanPhamMapper,  boSuuTapMapper);
    }

    @Override
    public SanPhamDTO fromModelToSearchDto(SanPham sanPham) {
        SanPhamDTO sanPhamDTO = new SanPhamDTO();

        return sanPhamDTO.toSearchDto(sanPham,  nhaCungCapMapper,  danhMucSanPhamMapper,  boSuuTapMapper);
    }

    @Override
    public SanPham fromDtoToModel(SanPhamDTO sanPhamDTO) {
        if (sanPhamDTO == null) {
            return null;
        }

        SanPham sanPham = new SanPham();

        return sanPham;
    }

    @Override
    public List<SanPham> fromDtoToModels(List<SanPhamDTO> sanPhamDTOS) {
        return sanPhamDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
