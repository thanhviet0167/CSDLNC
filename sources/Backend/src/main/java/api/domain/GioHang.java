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
    @NotNull
    @Column(name = "MaGioHang", unique = true, nullable = false)
    private Long maGioHang;

//    @NotNull
//    @Column(name = "KhachHang", length = 20, nullable = false)
//    private String khachHang; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "KhachHang", insertable = false, updatable = false, nullable = false)
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
    @JoinColumn(name = "NhaCungCap", nullable = false)
    @JsonIgnoreProperties(value = {
            "boSuuTapSet", "sanPhamSet",
            "theoDoiNhaCungCapSet", "voucherSet",
            "gioHangSet"
    })
    private NhaCungCap nhaCungCap;

    @NotNull
    @Column(name = "TongTienChuaKhuyenMai", nullable = false)
    private Long tongTienChuaKhuyenMai;

    @NotNull
    @Column(name = "TongTienQuaTang", nullable = false)
    private Long tongTienQuaTang;

    @NotNull
    @Column(name = "TrangThaiDatHang", nullable = false)
    private Boolean trangThaiDatHang;

    @NotNull
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
            @JoinColumn(name = "KhachHang", referencedColumnName = "Username"),
            @JoinColumn(name = "STT_SoDiaChi", referencedColumnName = "STT")
    })
    @JsonIgnoreProperties(value = {
            "khachHang",
            "gioHangSet"
    }, allowSetters = true)
    private SoDiaChi soDiaChi;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "gioHang"
    })
    private Set<ChiTietGioHang> chiTietGioHangSet = new HashSet<>();

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    private Set<VoucherApDung> voucherApDungSet = new HashSet<>();
}
