package api.service.dto;

import api.domain.*;
import api.service.mapper.KhachHangMapper;
import api.service.mapper.ThongTinThanhToanMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PhuongThucThanhToanDTO {

    private Boolean tinhTrangXacThuc;

    private KhachHangDTO khachHang;
    private ThongTinThanhToanDTO thongTinThanhToan;

    private Set<GiaoDich> giaoDichSet = new HashSet<>();

    public PhuongThucThanhToanDTO (PhuongThucThanhToan phuongThucThanhToan, KhachHangMapper khachHangMapper, ThongTinThanhToanMapper thongTinThanhToanMapper) {
        this.tinhTrangXacThuc = phuongThucThanhToan.getTinhTrangXacThuc();

        this.khachHang = khachHangMapper.fromModelToDto(phuongThucThanhToan.getKhachHang());
        this.thongTinThanhToan = thongTinThanhToanMapper.fromModelToDto(phuongThucThanhToan.getThongTinThanhToan());

        this.giaoDichSet.addAll(phuongThucThanhToan.getGiaoDichSet());
    }
}
