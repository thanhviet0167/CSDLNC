package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DanhMucSanPham")
@Getter
@Setter
@NoArgsConstructor
public class DanhMucSanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MaDanhMucSanPham", unique = true, nullable = false)
    private Long maDanhMucSanPham;

    @NotNull
    @Column(name = "TenDanhMucSanPham", length = 50, nullable = false)
    private String tenDanhMucSanPham;

    @Column(name = "MoTa", columnDefinition="TEXT")
    private String moTa;

//    @Column(name = "DanhMuc")
//    private Long danhMuc; // FK

    @ManyToOne
    @JoinColumn(name = "DanhMuc")
    @JsonIgnoreProperties(value = {"danhMucSanPhamSet"})
    private DanhMuc danhMuc;

    @OneToMany(mappedBy = "danhMucSanPham")
    @JsonIgnoreProperties(value = {
            "danhMucSanPham",
            "yeuThichSanPhamSet",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    // apDungVoucherSet
    private Set<SanPham> sanPhamSet = new HashSet<>();
}
