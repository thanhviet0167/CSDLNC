package api.service.dto;

import api.domain.*;
import api.service.mapper.GiaoDichMapper;
import api.service.mapper.GioHangMapper;
import api.service.mapper.HinhThucVanChuyenMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DonHangDTO {
    private Long maDonHang;
    private Boolean trangThaiThanhToan;
    private Instant ngayDat;
    private Long thanhTien;
    private Long phiVanChuyen;

    private GioHangDTO gioHang;

    private GiaoDichDTO giaoDich;

    private HinhThucVanChuyenDTO hinhThucVanChuyen;

    private Set<ThongTinVanChuyen> thongTinVanChuyenSet = new HashSet<>();

    private Set<KhieuNaiDonHang> khieuNaiDonHangSet = new HashSet<>();

    public DonHangDTO(DonHang donHang, GioHangMapper gioHangMapper, GiaoDichMapper giaoDichMapper, HinhThucVanChuyenMapper hinhThucVanChuyenMapper) {
        this.maDonHang = donHang.getMaDonHang();
        this.trangThaiThanhToan = donHang.getTrangThaiThanhToan();
        this.ngayDat = donHang.getNgayDat();
        this.thanhTien = donHang.getThanhTien();
        this.phiVanChuyen = donHang.getPhiVanChuyen();

        this.thongTinVanChuyenSet.addAll(donHang.getThongTinVanChuyenSet());
        this.khieuNaiDonHangSet.addAll(donHang.getKhieuNaiDonHangSet());

        this.gioHang = gioHangMapper.fromModelToDto(donHang.getGioHang());
        this.giaoDich = giaoDichMapper.fromModelToDto(donHang.getGiaoDich());
        this.hinhThucVanChuyen = hinhThucVanChuyenMapper.fromModelToDto(donHang.getHinhThucVanChuyen());

    }

}
