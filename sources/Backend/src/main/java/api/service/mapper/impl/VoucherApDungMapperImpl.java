package api.service.mapper.impl;

import api.domain.VoucherApDung;
import api.service.dto.VoucherApDungDTO;
import api.service.mapper.GioHangMapper;
import api.service.mapper.VoucherApDungMapper;
import api.service.mapper.VoucherMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VoucherApDungMapperImpl implements VoucherApDungMapper {

    private final GioHangMapper gioHangMapper;
    private final VoucherMapper voucherMapper;

    public VoucherApDungMapperImpl(GioHangMapper gioHangMapper, VoucherMapper voucherMapper) {
        this.gioHangMapper = gioHangMapper;
        this.voucherMapper = voucherMapper;
    }

    @Override
    public List<VoucherApDungDTO> fromModelToDtos(List<VoucherApDung> voucherApDungs) {
        return voucherApDungs.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VoucherApDungDTO fromModelToDto(VoucherApDung voucherApDung) {
        if (voucherApDung == null) {
            return null;
        }

        return new VoucherApDungDTO(voucherApDung,  gioHangMapper,  voucherMapper);
    }

    @Override
    public VoucherApDung fromDtoToModel(VoucherApDungDTO voucherApDungDTO) {
        if (voucherApDungDTO == null) {
            return null;
        }

        VoucherApDung voucherApDung = new VoucherApDung();

        return voucherApDung;
    }

    @Override
    public List<VoucherApDung> fromDtoToModels(List<VoucherApDungDTO> voucherApDungDTOS) {
        return voucherApDungDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
