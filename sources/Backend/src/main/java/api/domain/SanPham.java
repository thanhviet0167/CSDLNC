package api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@NoArgsConstructor
public class SanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
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

    @Column(name = "DanhMucSanPham", nullable = false)
    private Long danhMucSanPham; // FK

    @NotNull
    @Column(name = "NhaCungCap", nullable = false)
    private String nhaCungCap; // FK

    @Column(name = "STT_BoSuuTap", nullable = false)
    private Integer sttBoSuuTap;

    @NotNull
    @Column(name = "NgayTaoSanPham", nullable = false)
    private Instant ngayTaoSanPham;

}
