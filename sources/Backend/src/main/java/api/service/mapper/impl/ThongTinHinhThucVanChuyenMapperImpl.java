package api.service.mapper.impl;

import api.domain.ThongTinHinhThucVanChuyen;
import api.service.dto.HinhThucVanChuyenDTO;
import api.service.dto.ThongTinHinhThucVanChuyenDTO;
import api.service.mapper.HinhThucVanChuyenMapper;
import api.service.mapper.ThongTinHinhThucVanChuyenMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ThongTinHinhThucVanChuyenMapperImpl implements ThongTinHinhThucVanChuyenMapper {

    private final HinhThucVanChuyenMapper hinhThucVanChuyenMapper;

    public ThongTinHinhThucVanChuyenMapperImpl(HinhThucVanChuyenMapper hinhThucVanChuyenMapper) {
        this.hinhThucVanChuyenMapper = hinhThucVanChuyenMapper;
    }

    @Override
    public List<ThongTinHinhThucVanChuyenDTO> fromModelToDtos(List<ThongTinHinhThucVanChuyen> thongTinHinhThucVanChuyens) {
        return thongTinHinhThucVanChuyens.stream().map(this::fromModelToDto).collect(Collectors.toList());
    }

    @Override
    public ThongTinHinhThucVanChuyenDTO fromModelToDto(ThongTinHinhThucVanChuyen thongTinHinhThucVanChuyen) {
        if (thongTinHinhThucVanChuyen == null) {
            return null;
        }

        ThongTinHinhThucVanChuyenDTO thongTinHinhThucVanChuyenDTO = new ThongTinHinhThucVanChuyenDTO();

        HinhThucVanChuyenDTO hinhThucVanChuyenDTO = hinhThucVanChuyenMapper.fromModelToDto(thongTinHinhThucVanChuyen.getHinhThucVanChuyen());

        ThongTinHinhThucVanChuyenDTO.ThongTinHinhThucVanChuyenIDDTO thongTinHinhThucVanChuyenIDDTO = new ThongTinHinhThucVanChuyenDTO.ThongTinHinhThucVanChuyenIDDTO();
        thongTinHinhThucVanChuyenIDDTO.setMaHinhThucVanChuyen(thongTinHinhThucVanChuyen.getThongTinHinhThucVanChuyenID().getMaHinhThucVanChuyen());
        thongTinHinhThucVanChuyenIDDTO.setPhamViVanChuyen(thongTinHinhThucVanChuyen.getThongTinHinhThucVanChuyenID().getPhamViVanChuyen());

        thongTinHinhThucVanChuyenDTO.setThongTinHinhThucVanChuyenID(thongTinHinhThucVanChuyenIDDTO);
        thongTinHinhThucVanChuyenDTO.setHinhThucVanChuyen(hinhThucVanChuyenDTO);
        thongTinHinhThucVanChuyenDTO.setPhamViVanChuyen(thongTinHinhThucVanChuyen.getThongTinHinhThucVanChuyenID().getPhamViVanChuyen());
        thongTinHinhThucVanChuyenDTO.setPhiGiaoHang(thongTinHinhThucVanChuyen.getPhiGiaoHang());
        thongTinHinhThucVanChuyenDTO.setThoiGianGiaoHang(thongTinHinhThucVanChuyenDTO.getThoiGianGiaoHang());

        return thongTinHinhThucVanChuyenDTO;
    }

    @Override
    public ThongTinHinhThucVanChuyen fromDtoToModel(ThongTinHinhThucVanChuyenDTO thongTinHinhThucVanChuyenDTO) {
        if (thongTinHinhThucVanChuyenDTO == null) {
            return null;
        }

        ThongTinHinhThucVanChuyen thongTinHinhThucVanChuyen = new ThongTinHinhThucVanChuyen();

        ThongTinHinhThucVanChuyen.ThongTinHinhThucVanChuyenID thongTinHinhThucVanChuyenID = new ThongTinHinhThucVanChuyen.ThongTinHinhThucVanChuyenID();
        thongTinHinhThucVanChuyenID.setMaHinhThucVanChuyen(thongTinHinhThucVanChuyenDTO.getThongTinHinhThucVanChuyenID().getMaHinhThucVanChuyen());
        thongTinHinhThucVanChuyenID.setPhamViVanChuyen(thongTinHinhThucVanChuyenDTO.getThongTinHinhThucVanChuyenID().getPhamViVanChuyen());

        thongTinHinhThucVanChuyen.setThongTinHinhThucVanChuyenID(thongTinHinhThucVanChuyenID);
        thongTinHinhThucVanChuyen.setThoiGianGiaoHang(thongTinHinhThucVanChuyenDTO.getThoiGianGiaoHang());
        thongTinHinhThucVanChuyen.setPhiGiaoHang(thongTinHinhThucVanChuyenDTO.getPhiGiaoHang());

        return thongTinHinhThucVanChuyen;
    }

    @Override
    public List<ThongTinHinhThucVanChuyen> fromDtoToModels(List<ThongTinHinhThucVanChuyenDTO> thongTinHinhThucVanChuyenDTOS) {
        return thongTinHinhThucVanChuyenDTOS.stream().map(this::fromDtoToModel).collect(Collectors.toList());
    }

    @Override
    public Set<ThongTinHinhThucVanChuyenDTO> fromModelToDtoSet(Set<ThongTinHinhThucVanChuyen> thongTinHinhThucVanChuyenSet) {
        return thongTinHinhThucVanChuyenSet.stream().map(this::fromModelToDto).collect(Collectors.toSet());
    }

    @Override
    public Set<ThongTinHinhThucVanChuyen> fromDtoToModelSet(Set<ThongTinHinhThucVanChuyenDTO> thongTinHinhThucVanChuyenDTOSet) {
        return thongTinHinhThucVanChuyenDTOSet.stream().map(this::fromDtoToModel).collect(Collectors.toSet());
    }
}
