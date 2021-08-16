package api.service.dto;

import api.domain.*;
import api.service.mapper.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class GioHangDTO {

    private Long maGioHang;
    private Long tongTienChuaKhuyenMai;
    private Long tongTienQuaTang;
    private Boolean trangThaiDatHang;
    private Long soTienGiamThucTe;

    private DonHangDTO donHang;
    private KhachHangDTO khachHang;
    private NhaCungCapDTO nhaCungCap;
    private VoucherDTO voucher;
    private SoDiaChiDTO soDiaChi;

    private Set<ChiTietGioHang> chiTietGioHangSet = new HashSet<>();
    private Set<VoucherApDung> voucherApDungSet = new HashSet<>();

    public GioHangDTO (GioHang gioHang, DonHangMapper donHangMapper, KhachHangMapper khachHangMapper, NhaCungCapMapper nhaCungCapMapper, VoucherMapper voucherMapper, SoDiaChiMapper soDiaChiMapper) {
        this.maGioHang = gioHang.getMaGioHang();
        this.tongTienChuaKhuyenMai = gioHang.getTongTienChuaKhuyenMai();
        this.tongTienQuaTang = gioHang.getTongTienQuaTang();
        this.trangThaiDatHang = gioHang.getTrangThaiDatHang();
        this.soTienGiamThucTe = gioHang.getSoTienGiamThucTe();

        this.donHang = donHangMapper.fromModelToDto(gioHang.getDonHang());
        this.khachHang = khachHangMapper.fromModelToDto(gioHang.getKhachHang());
        this.nhaCungCap = nhaCungCapMapper.fromModelToDto(gioHang.getNhaCungCap());
        this.voucher = voucherMapper.fromModelToDto(gioHang.getVoucher());
        this.soDiaChi = soDiaChiMapper.fromModelToDto(gioHang.getSoDiaChi());

        this.chiTietGioHangSet.addAll(gioHang.getChiTietGioHangSet());
        this.voucherApDungSet.addAll(gioHang.getVoucherApDungSet());
    }

}
