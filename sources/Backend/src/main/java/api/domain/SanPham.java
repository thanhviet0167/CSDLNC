package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@NoArgsConstructor
public class SanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSanPham", unique = true, nullable = false)
    private Long maSanPham;

    @NotNull
    @Column(name = "TenSanPham", length = 50, nullable = false)
    private String tenSanPham;

    @Column(name = "HinhAnh", length = 100)
    private String hinhAnh;

    @Column(name = "XuatXu", length = 50)
    private String xuatXu;

    @Column(name = "MoTa", columnDefinition="TEXT")
    private String moTa;

    @NotNull
    @Column(name = "GiaHienHanh", nullable = false)
    private Long giaHienHanh;

    @NotNull
    @Column(name = "SoLuongTon", nullable = false)
    private Integer soLuongTon;

    @Column(name = "GiaSi")
    private Long giaSi;

    @Column(name = "SoLuongSi")
    private Integer soLuongSi;

    @Column(name = "GiaGiam")
    private Long giaGiam;

    @Column(name = "SoLuongGiamGia")
    private Integer soLuongGiamGia;

    @NotNull
    @Column(name = "NgayTaoSanPham", nullable = false)
    private Instant ngayTaoSanPham;

    @Transient
    private Integer rate;

//    @NotNull
//    @Column(name = "NhaCungCap", nullable = false)
//    private String nhaCungCap; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "NhaCungCap", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "boSuuTapSet", "sanPhamSet",
            "theoDoiNhaCungCapSet", "voucherSet",
            "gioHangSet"
    })
    private NhaCungCap nhaCungCap;

    //    @Column(name = "DanhMucSanPham", nullable = false)
    //    private Long danhMucSanPham; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "DanhMucSanPham", nullable = false)
    @JsonIgnoreProperties(value = {"sanPhamSet"})
    private DanhMucSanPham danhMucSanPham;

    //    @Column(name = "STT_BoSuuTap", nullable = false)
    //    private Integer sttBoSuuTap;
    @ManyToOne
    @NotFound( action = NotFoundAction.IGNORE )
    @JoinColumns({
            @JoinColumn(name = "NhaCungCap", referencedColumnName = "Username"),
            @JoinColumn(name = "STT_BoSuuTap", referencedColumnName = "STT")
    })
    @JsonIgnoreProperties(value = {
            "nhaCungCap",
            "sanPhamSet"
    })
    private BoSuuTap boSuuTap;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "sanPham"
    })
    private Set<SanPhamYeuThich> yeuThichSanPhamSet = new HashSet<>();

    @Where(clause = "NgayKetThuc > CURRENT_TIMESTAMP")
    @OneToMany(mappedBy = "sanPhamApDung", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "gioHangSet",
            "voucherApDungSet"
    })
    private Set<Voucher> apDungVoucherSet = new HashSet<>();

    @OneToMany(mappedBy = "sanPhamTangKem", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "sanPhamTangKem"
    })
    private Set<ChiTietVoucher> tangKemVoucherSet = new HashSet<>();

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "sanPham"
    })
    private Set<XemSanPham> xemSanPhamSet = new HashSet<>();

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "sanPham"
    })
    private Set<ChiTietGioHang> chiTietGioHangSet = new HashSet<>();

    @OneToMany(mappedBy = "sanPhamTangKem", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "sanPhamTangKem"
    })
    private Set<ChiTietQuaTang> sanPhamTangKemChiTietQuaTangSet = new HashSet<>();
}
