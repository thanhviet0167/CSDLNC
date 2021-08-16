package api.service.mapper.impl;

import api.domain.ThongTinCongThanhToan;
import api.service.dto.ThongTinCongThanhToanDTO;
import api.service.mapper.ThongTinCongThanhToanMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ThongTinCongThanhToanMapperImpl implements ThongTinCongThanhToanMapper {
    @Override
    public List<ThongTinCongThanhToanDTO> fromModelToDtos(List<ThongTinCongThanhToan> thongTinCongThanhToans) {
        return thongTinCongThanhToans.stream()
                .filter(Objects::nonNull)
                .map(this::fromModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ThongTinCongThanhToanDTO fromModelToDto(ThongTinCongThanhToan thongTinCongThanhToan) {
        if (thongTinCongThanhToan == null) {
            return null;
        }

        return new ThongTinCongThanhToanDTO(thongTinCongThanhToan);
    }

    @Override
    public ThongTinCongThanhToan fromDtoToModel(ThongTinCongThanhToanDTO thongTinCongThanhToanDTO) {
        if (thongTinCongThanhToanDTO == null) {
            return null;
        }

        ThongTinCongThanhToan thongTinCongThanhToan = new ThongTinCongThanhToan();

        return thongTinCongThanhToan;
    }

    @Override
    public List<ThongTinCongThanhToan> fromDtoToModels(List<ThongTinCongThanhToanDTO> thongTinCongThanhToanDTOS) {
        return thongTinCongThanhToanDTOS.stream()
                .filter(Objects::nonNull)
                .map(this::fromDtoToModel)
                .collect(Collectors.toList());
    }
}
