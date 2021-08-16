package api.service.mapper.impl;

import api.domain.ThongTinThanhToan;
import api.service.dto.ThongTinThanhToanDTO;
import api.service.mapper.ThongTinCongThanhToanMapper;
import api.service.mapper.ThongTinThanhToanMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ThongTinThanhToanMapperImpl implements ThongTinThanhToanMapper {
    private final ThongTinCongThanhToanMapper thongTinCongThanhToanMapper;

    public ThongTinThanhToanMapperImpl(ThongTinCongThanhToanMapper thongTinCongThanhToanMapper) {
        this.thongTinCongThanhToanMapper = thongTinCongThanhToanMapper;
    }

    @Override
    public List<ThongTinThanhToanDTO> fromModelToDtos(List<ThongTinThanhToan> thongTinThanhToans) {
        return thongTinThanhToans.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ThongTinThanhToanDTO fromModelToDto(ThongTinThanhToan thongTinThanhToan) {
        if (thongTinThanhToan == null) {
            return null;
        }

        return new ThongTinThanhToanDTO(thongTinThanhToan,  thongTinCongThanhToanMapper);
    }

    @Override
    public ThongTinThanhToan fromDtoToModel(ThongTinThanhToanDTO thongTinThanhToanDTO) {
        if (thongTinThanhToanDTO == null) {
            return null;
        }

        ThongTinThanhToan thongTinThanhToan = new ThongTinThanhToan();

        return thongTinThanhToan;
    }

    @Override
    public List<ThongTinThanhToan> fromDtoToModels(List<ThongTinThanhToanDTO> thongTinThanhToanDTOS) {
        return thongTinThanhToanDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
