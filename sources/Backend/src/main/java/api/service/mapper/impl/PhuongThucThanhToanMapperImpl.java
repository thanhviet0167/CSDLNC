package api.service.mapper.impl;

import api.domain.PhuongThucThanhToan;
import api.service.dto.PhuongThucThanhToanDTO;
import api.service.mapper.KhachHangMapper;
import api.service.mapper.PhuongThucThanhToanMapper;
import api.service.mapper.ThongTinThanhToanMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PhuongThucThanhToanMapperImpl implements PhuongThucThanhToanMapper {
    private final KhachHangMapper khachHangMapper;
    private final ThongTinThanhToanMapper thongTinThanhToanMapper;

    public PhuongThucThanhToanMapperImpl(KhachHangMapper khachHangMapper, ThongTinThanhToanMapper thongTinThanhToanMapper) {
        this.khachHangMapper = khachHangMapper;
        this.thongTinThanhToanMapper = thongTinThanhToanMapper;
    }

    @Override
    public List<PhuongThucThanhToanDTO> fromModelToDtos(List<PhuongThucThanhToan> phuongThucThanhToans) {
        return phuongThucThanhToans.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PhuongThucThanhToanDTO fromModelToDto(PhuongThucThanhToan phuongThucThanhToan) {
        if (phuongThucThanhToan == null) {
            return null;
        }

        return new PhuongThucThanhToanDTO(phuongThucThanhToan,  khachHangMapper,  thongTinThanhToanMapper);
    }

    @Override
    public PhuongThucThanhToan fromDtoToModel(PhuongThucThanhToanDTO phuongThucThanhToanDTO) {
        if (phuongThucThanhToanDTO == null) {
            return null;
        }

        PhuongThucThanhToan phuongThucThanhToan = new PhuongThucThanhToan();

        return phuongThucThanhToan;
    }

    @Override
    public List<PhuongThucThanhToan> fromDtoToModels(List<PhuongThucThanhToanDTO> phuongThucThanhToanDTOS) {
        return phuongThucThanhToanDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
