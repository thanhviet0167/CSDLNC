package api.service.dto;

import api.domain.ThongTinVanChuyen;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class ThongTinVanChuyenDTO {

    private String trangThaiVanChuyen;
    private Instant thoiGianVanChuyen;

    private NhanVienDTO nhanVienGiaoHang;
    private DonHangDTO donHang;

    public ThongTinVanChuyenDTO(ThongTinVanChuyen thongTinVanChuyen, NhanVienMapper nhanVienMapper, DonHangMapper donHangMapper) {
        this.trangThaiVanChuyen = thongTinVanChuyen.getTrangThaiVanChuyen();
        this.thoiGianVanChuyen = thongTinVanChuyen.getThoiGianVanChuyen();

        this.nhanVienGiaoHang = nhanVienMapper.fromModelToDto(thongTinVanChuyen.getNhanVienGiaoHang());
        this.donHang = donHangMapper.fromModelToDto(thongTinVanChuyen.getDonHang());
    }
}
