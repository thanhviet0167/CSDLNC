package api.service.dto;

import api.service.mapper.GioHangMapper;
import api.service.mapper.SanPhamMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;
import api.domain.ChiTietGioHang;

@Getter
@Setter
@NoArgsConstructor
public class ChiTietGioHangDTO {

    private GioHangDTO gioHang;
    private SanPhamDTO sanPham;

    private Integer soLuongMua;

    private Long giaBanThucTe;

    private Long giaGiam;

    @Min(0)
    @Max(5)
    private Integer danhGia;

    private String binhLuan;

    private Instant thoiGianDanhGia;

    public ChiTietGioHangDTO(ChiTietGioHang chiTietGioHang, GioHangMapper gioHangMapper, SanPhamMapper sanPhamMapper) {
        this.soLuongMua = chiTietGioHang.getSoLuongMua();
        this.giaBanThucTe = chiTietGioHang.getGiaBanThucTe();
        this.giaGiam = chiTietGioHang.getGiaGiam();
        this.danhGia = chiTietGioHang.getDanhGia();
        this.binhLuan = chiTietGioHang.getBinhLuan();
        this.thoiGianDanhGia = chiTietGioHang.getThoiGianDanhGia();

        this.gioHang = gioHangMapper.fromModelToDto(chiTietGioHang.getGioHang());
        this.sanPham = sanPhamMapper.fromModelToDto(chiTietGioHang.getSanPham());
    }

}
