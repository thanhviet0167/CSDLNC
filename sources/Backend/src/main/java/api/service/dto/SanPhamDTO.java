package api.service.dto;

import api.domain.*;
import api.service.mapper.BoSuuTapMapper;
import api.service.mapper.DanhMucSanPhamMapper;
import api.service.mapper.NhaCungCapMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SanPhamDTO {

    private Long maSanPham;
    private String tenSanPham;
    private String hinhAnh;
    private String xuatXu;
    private String moTa;
    private Long giaHienHanh;
    private Integer soLuongTon;
    private Long giaSi;
    private Integer soLuongSi;
    private Long giaGiam;
    private Integer soLuongGiamGia;
    private Instant ngayTaoSanPham;

    private NhaCungCapDTO nhaCungCap;

    private DanhMucSanPhamDTO danhMucSanPham;

    private BoSuuTapDTO boSuuTap;

    private Set<SanPhamYeuThich> yeuThichSanPhamSet = new HashSet<>();
    private Set<Voucher> apDungVoucherSet = new HashSet<>();
    private Set<ChiTietVoucher> tangKemVoucherSet = new HashSet<>();
    private Set<XemSanPham> xemSanPhamSet = new HashSet<>();
    private Set<ChiTietGioHang> chiTietGioHangSet = new HashSet<>();
    private Set<ChiTietQuaTang> sanPhamTangKemChiTietQuaTangSet = new HashSet<>();

    public SanPhamDTO(SanPham sanPham, NhaCungCapMapper nhaCungCapMapper, DanhMucSanPhamMapper danhMucSanPhamMapper, BoSuuTapMapper boSuuTapMapper) {
        this.maSanPham = sanPham.getMaSanPham();
        this.tenSanPham = sanPham.getTenSanPham();
        this.hinhAnh = sanPham.getHinhAnh();
        this.xuatXu = sanPham.getXuatXu();
        this.moTa = sanPham.getMoTa();
        this.giaHienHanh = sanPham.getGiaHienHanh();
        this.soLuongTon = sanPham.getSoLuongTon();
        this.giaSi = sanPham.getGiaSi();
        this.soLuongSi = sanPham.getSoLuongSi();
        this.giaGiam = sanPham.getGiaGiam();
        this.soLuongGiamGia = sanPham.getSoLuongGiamGia();
        this.ngayTaoSanPham = sanPham.getNgayTaoSanPham();

        this.nhaCungCap = nhaCungCapMapper.fromModelToDto(sanPham.getNhaCungCap());
        this.danhMucSanPham = danhMucSanPhamMapper.fromModelToDto(sanPham.getDanhMucSanPham());
        this.boSuuTap = boSuuTapMapper.fromModelToDto(sanPham.getBoSuuTap());

        this.yeuThichSanPhamSet.addAll(sanPham.getYeuThichSanPhamSet());
        this.apDungVoucherSet.addAll(sanPham.getApDungVoucherSet());
        this.tangKemVoucherSet.addAll(sanPham.getTangKemVoucherSet());
        this.xemSanPhamSet.addAll(sanPham.getXemSanPhamSet());
        this.chiTietGioHangSet.addAll(sanPham.getChiTietGioHangSet());
        this.sanPhamTangKemChiTietQuaTangSet.addAll(sanPham.getSanPhamTangKemChiTietQuaTangSet());
    }

}
