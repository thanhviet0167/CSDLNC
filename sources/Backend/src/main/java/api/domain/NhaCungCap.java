package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NhaCungCap")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class NhaCungCap extends KhachHang {

    @NotNull
    @Column(name = "TenNhaCungCap", length = 100, nullable = false)
    private String tenNhaCungCap;

    @Column(name = "MoTa", length = 300)
    private String moTa;

    @NotNull
    @Column(name = "NgayThamGia", nullable = false)
    private Instant ngayThamGia;

    @NotNull
    @Column(name = "SDT_LienLac", length = 11, nullable = false)
    private String sdtLienLac;

    @NotNull
    @Column(name = "DiaChi", length = 100, nullable = false)
    private String diaChi;

//    @NotNull
//    @Column(name = "MaTinhThanhPho", nullable = false)
//    private Integer tinhThanhPho; // FK

    @ManyToOne
    @JoinColumn(name = "MaTinhThanhPho", nullable = false)
    @JsonIgnoreProperties(value = {
            "nhaCungCapSet", "soDiaChiSet"
    }, allowSetters = true)
    private TinhThanhPho tinhThanhPho;

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.EAGER)
    private Set<BoSuuTap> boSuuTapSet = new HashSet<>();

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {
            "nhaCungCap",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    // yeuThichSanPhamSet, apDungVoucherSet
    private Set<SanPham> sanPhamSet = new HashSet<>();

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    private Set<TheoDoiNhaCungCap> theoDoiNhaCungCapSet = new HashSet<>();

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {
            "gioHangSet",
            "voucherApDungSet"
    })
    // chiTietVoucherSet
    private Set<Voucher> voucherSet = new HashSet<>();

    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {
            "nhaCungCap"
    })
    private Set<GioHang> gioHangSet = new HashSet<>();
}
