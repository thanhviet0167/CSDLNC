package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Voucher")
@Getter
@Setter
@NoArgsConstructor
public class Voucher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaVoucher", unique=true, nullable = false)
    private Long maVoucher;

    @NotNull
    @Column(name = "SoLuongVoucher", nullable = false)
    private Integer soLuongVoucher;

    @NotNull
    @Column(name = "NgayBatDau", nullable = false)
    private Instant ngayBatDau;

    @NotNull
    @Column(name = "NgayKetThuc", nullable = false)
    private Instant ngayKetThuc;

    @NotNull
    @Column(name = "LoaiVoucher", nullable = false)
    private Integer loaiVoucher;

    @Column(name = "GiaTriDonHangToiThieu")
    private Long giaTriDonHangToiThieu;

    @Column(name = "PhanTramKhuyenMai")
    private Float phanTramKhuyenMai;

    @Column(name = "SoTienGiamToiDa")
    private Long soTienGiamToiDa;

//    @Column(name = "SanPhamApDung", nullable = false)
//    private Long sanPhamApDung;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "SanPhamApDung")
    @JsonIgnoreProperties(value = {
            "yeuThichSanPhamSet", "apDungVoucherSet",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    private SanPham sanPhamApDung;

//    @Column(name = "NhaCungCap", length = 20, nullable = false)
//    private String nhaCungCap;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "NhaCungCap")
    @JsonIgnoreProperties(value = {
            "boSuuTapSet", "sanPhamSet",
            "theoDoiNhaCungCapSet", "voucherSet",
            "gioHangSet"
    })
    private NhaCungCap nhaCungCap;

    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "voucher"
    })
    private Set<ChiTietVoucher> chiTietVoucherSet = new HashSet<>();

    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "voucher"
    })
    private Set<GioHang> gioHangSet = new HashSet<>();

    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<VoucherApDung> voucherApDungSet = new HashSet<>();
}
