package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GioHang")
@Getter
@Setter
@NoArgsConstructor
public class GioHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaGioHang", unique = true, nullable = false)
    private Long maGioHang;

//    @NotNull
//    @Column(name = "KhachHang", length = 20, nullable = false)
//    private String khachHang; // FK

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "KhachHang", referencedColumnName = "Username", nullable = false)
    @JsonIgnoreProperties(value = {
            "soDiaChiSet", "phuongThucThanhToanSet",
            "sanPhamYeuThichSet", "theoDoiNhaCungCapSet",
            "xemSanPhamSet", "gioHangSet"
    }, allowSetters = true)
    private KhachHang khachHang;

//    @NotNull
//    @Column(name = "NhaCungCap", length = 20, nullable = false)
//    private String nhaCungCap; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "NhaCungCap")
    @JsonIgnoreProperties(value = {
            "boSuuTapSet", "sanPhamSet",
            "theoDoiNhaCungCapSet", "voucherSet",
            "gioHangSet"
    })
    private NhaCungCap nhaCungCap;

    @Column(name = "TongTienChuaKhuyenMai", nullable = false)
    private Long tongTienChuaKhuyenMai;

    @Column(name = "TongTienQuaTang", nullable = false)
    private Long tongTienQuaTang;

    @Column(name = "TrangThaiDatHang", nullable = false)
    private Boolean trangThaiDatHang;

    @Column(name = "SoTienGiamThucTe", nullable = false)
    private Long soTienGiamThucTe;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "DonHang")
//    @JsonIgnoreProperties(value = {
//            "gioHang"
//    })
//    private DonHang donHang;

//    @Column(name = "MaVoucher")
//    private Long maVoucher; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "MaVoucher")
    @JsonIgnoreProperties(value = {
            "gioHangSet",
            "voucherApDungSet"
    })
    // chiTietVoucherSet
    private Voucher voucher;

//    @Column(name = "STT_SoDiaChi")
//    private Integer sttSoDiaChi; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
            @JoinColumn(name = "KhachHang", referencedColumnName = "Username",  updatable = false, insertable = false),
            @JoinColumn(name = "STT_SoDiaChi", referencedColumnName = "STT",  updatable = false, insertable = false)
    })
    @JsonIgnoreProperties(value = {
            "khachHang",
            "gioHangSet"
    }, allowSetters = true)
    private SoDiaChi soDiaChi;

    @Column(name = "STT_SoDiaChi")
    private Integer sttSoDiaChi;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "gioHang"
    })
    private Set<ChiTietGioHang> chiTietGioHangSet = new HashSet<>();

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<VoucherApDung> voucherApDungSet = new HashSet<>();

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<DonHang> donHangSet = new HashSet<>();
}
