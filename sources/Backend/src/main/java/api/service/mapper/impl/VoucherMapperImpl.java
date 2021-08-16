package api.service.mapper.impl;

import api.domain.Voucher;
import api.service.dto.VoucherDTO;
import api.service.mapper.NhaCungCapMapper;
import api.service.mapper.SanPhamMapper;
import api.service.mapper.VoucherMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class VoucherMapperImpl implements VoucherMapper {
    private final SanPhamMapper sanPhamMapper;
    private final NhaCungCapMapper nhaCungCapMapper;

    public VoucherMapperImpl (SanPhamMapper sanPhamMapper, NhaCungCapMapper nhaCungCapMapper) {
        this.sanPhamMapper = sanPhamMapper;
        this.nhaCungCapMapper = nhaCungCapMapper;
    }

    @Override
    public List<VoucherDTO> fromModelToDtos(List<Voucher> vouchers) {
        return vouchers.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VoucherDTO fromModelToDto(Voucher voucher) {
        if (voucher == null) {
            return null;
        }

        return new VoucherDTO( voucher, sanPhamMapper,  nhaCungCapMapper);
    }

    @Override
    public Voucher fromDtoToModel(VoucherDTO voucherDTO) {
        if (voucherDTO == null) {
            return null;
        }

        Voucher voucher = new Voucher();

        return voucher;
    }

    @Override
    public List<Voucher> fromDtoToModels(List<VoucherDTO> voucherDTOS) {
        return voucherDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
