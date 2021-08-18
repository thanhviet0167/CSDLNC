package api.service.mapper.impl;

import api.domain.HinhThucVanChuyen;
import api.service.dto.HinhThucVanChuyenDTO;
import api.service.dto.ThongTinHinhThucVanChuyenDTO;
import api.service.mapper.HinhThucVanChuyenMapper;
import api.service.mapper.ThongTinHinhThucVanChuyenMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class HinhThucVanChuyenMapperImpl implements HinhThucVanChuyenMapper {

    private final ThongTinHinhThucVanChuyenMapper thongTinHinhThucVanChuyenMapper;

    public HinhThucVanChuyenMapperImpl(ThongTinHinhThucVanChuyenMapper thongTinHinhThucVanChuyenMapper) {
        this.thongTinHinhThucVanChuyenMapper = thongTinHinhThucVanChuyenMapper;
    }

    @Override
    public List<HinhThucVanChuyenDTO> fromModelToDtos(List<HinhThucVanChuyen> hinhThucVanChuyens) {
        return hinhThucVanChuyens.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public HinhThucVanChuyenDTO fromModelToDto(HinhThucVanChuyen hinhThucVanChuyen) {
        if (hinhThucVanChuyen == null) {
            return null;
        }

        HinhThucVanChuyenDTO hinhThucVanChuyenDTO = new HinhThucVanChuyenDTO();
        Set<ThongTinHinhThucVanChuyenDTO> thongTinHinhThucVanChuyenDTOSet = thongTinHinhThucVanChuyenMapper.fromModelToDtoSet(hinhThucVanChuyen.getThongTinHinhThucVanChuyenSet());

        hinhThucVanChuyenDTO.setMaHinhThucVanChuyen(hinhThucVanChuyen.getMaHinhThucVanChuyen());
        hinhThucVanChuyenDTO.setTenHinhThucVanChuyen(hinhThucVanChuyen.getTenHinhThucVanChuyen());
        hinhThucVanChuyenDTO.setThongTinHinhThucVanChuyenSet(thongTinHinhThucVanChuyenDTOSet);

        return hinhThucVanChuyenDTO;
    }

    @Override
    public HinhThucVanChuyen fromDtoToModel(HinhThucVanChuyenDTO hinhThucVanChuyenDTO) {
        if (hinhThucVanChuyenDTO == null) {
            return null;
        }

        HinhThucVanChuyen hinhThucVanChuyen = new HinhThucVanChuyen();

        hinhThucVanChuyen.setMaHinhThucVanChuyen(hinhThucVanChuyenDTO.getMaHinhThucVanChuyen());
        hinhThucVanChuyen.setTenHinhThucVanChuyen(hinhThucVanChuyenDTO.getTenHinhThucVanChuyen());

        return hinhThucVanChuyen;
    }

    @Override
    public List<HinhThucVanChuyen> fromDtoToModels(List<HinhThucVanChuyenDTO> hinhThucVanChuyenDTOS) {
        return hinhThucVanChuyenDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Set<HinhThucVanChuyenDTO> fromModelToDtoSet(Set<HinhThucVanChuyen> hinhThucVanChuyenSet) {
        return hinhThucVanChuyenSet.stream().map(this::fromModelToDto).collect(Collectors.toSet());
    }

    @Override
    public Set<HinhThucVanChuyen> fromDtoToModelSet(Set<HinhThucVanChuyenDTO> hinhThucVanChuyenDtoSet) {
        return hinhThucVanChuyenDtoSet.stream().map(this::fromDtoToModel).collect(Collectors.toSet());
    }
}
