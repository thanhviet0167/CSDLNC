package api.service.dto;

import api.domain.*;
import api.service.mapper.NhaCungCapMapper;
import api.service.mapper.SanPhamMapper;
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
public class VoucherDTO {

    private Long maVoucher;
    private Integer soLuongVoucher;
    private Instant ngayBatDau;
    private Instant ngayKetThuc;
    private Integer loaiVoucher;
    private Long giaTriDonHangToiThieu;
    private Float phanTramKhuyenMai;
    private Long soTienGiamToiDa;

    private SanPhamDTO sanPhamApDung;

    private NhaCungCapDTO nhaCungCap;

    private Set<ChiTietVoucher> chiTietVoucherSet = new HashSet<>();
    private Set<GioHang> gioHangSet = new HashSet<>();
    private Set<VoucherApDung> voucherApDungSet = new HashSet<>();

    public VoucherDTO (Voucher voucher, SanPhamMapper sanPhamMapper, NhaCungCapMapper nhaCungCapMapper) {
        this.maVoucher = voucher.getMaVoucher();
        this.soLuongVoucher = voucher.getSoLuongVoucher();
        this.ngayBatDau = voucher.getNgayBatDau();
        this.ngayKetThuc = voucher.getNgayKetThuc();
        this.loaiVoucher = voucher.getLoaiVoucher();
        this.giaTriDonHangToiThieu = voucher.getGiaTriDonHangToiThieu();
        this.phanTramKhuyenMai = voucher.getPhanTramKhuyenMai();
        this.soTienGiamToiDa = voucher.getSoTienGiamToiDa();

        this.sanPhamApDung = sanPhamMapper.fromModelToDto(voucher.getSanPhamApDung());
        this.nhaCungCap = nhaCungCapMapper.fromModelToDto(voucher.getNhaCungCap());

        this.chiTietVoucherSet.addAll(voucher.getChiTietVoucherSet());
        this.gioHangSet.addAll(voucher.getGioHangSet());
        this.voucherApDungSet.addAll(voucher.getVoucherApDungSet());
    }

}
