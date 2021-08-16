package api.service.dto;

import api.domain.KhieuNaiDonHang;
import api.service.mapper.NhanVienMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class KhieuNaiDonHangDTO {
    private Instant ngayTaoKhieuNai;
    private Boolean noiDungKhieuNai;

    @Max(2)
    @Min(0)
    private Integer trangThaiXuLy;

    @Max(5)
    @Min(0)
    private Integer mucDoHaiLongKhachHang;

    private NhanVienDTO nhanVienXuLy;
    private DonHangDTO donHang;
    private Integer stt;

    public KhieuNaiDonHangDTO (KhieuNaiDonHang khieuNaiDonHang, NhanVienMapper nhanVienMapper, DonHangMapper donHangMapper) {
        this.ngayTaoKhieuNai = khieuNaiDonHang.getNgayTaoKhieuNai();
        this.noiDungKhieuNai = khieuNaiDonHang.getNoiDungKhieuNai();
        this.trangThaiXuLy = khieuNaiDonHang.getTrangThaiXuLy();
        this.mucDoHaiLongKhachHang = khieuNaiDonHang.getMucDoHaiLongKhachHang();

        this.nhanVienXuLy = nhanVienMapper.fromModelToDto(khieuNaiDonHang.getNhanVienXuLy());
        this.donHang = donHangMapper.fromModelToDto(khieuNaiDonHang.getDonHang());
        this.stt = khieuNaiDonHang.getKhieuNaiDonHangID().getStt();

    }
}
