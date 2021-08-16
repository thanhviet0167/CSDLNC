package api.service.dto;

import api.domain.XemSanPham;
import api.service.mapper.KhachHangMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class XemSanPhamDTO {
    private SanPhamDTO sanPham;
    private KhachHangDTO khachHang;
    private Instant thoiGian;

    public XemSanPhamDTO (XemSanPham xemSanPham, SanPhamMapper sanPhamMapper, KhachHangMapper khachHangMapper) {
        this.sanPham = sanPhamMapper.fromModelToDto(xemSanPham.getSanPham());
        this.khachHang = khachHangMapper.fromModelToDto(xemSanPham.getKhachHang());
        this.thoiGian = xemSanPham.getXemSanPhamID().getThoiGian();
    }
}
