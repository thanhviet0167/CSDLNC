package api.domain;

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

@Entity
@Table(name = "GiaoDich")
@Getter
@Setter
@NoArgsConstructor
public class GiaoDich implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MaGiaoDich", unique = true, nullable = false)
    private Long maGiaoDich;

    @NotNull
    @Column(name = "TongTien", nullable = false)
    private Long tongTien;

    @Column(name = "TrangThaiThanhToan", nullable = false)
    private Boolean trangThaiThanhToan;

    @NotNull
    @Column(name = "NgayThanhToan", nullable = false)
    private Instant ngayThanhToan;

//    @NotNull
//    @Column(name = "KhachHang", length = 20, nullable = false)
//    private String khachHang; // FK
//
//    @NotNull
//    @Column(name = "TaiKhoanThanhToan", length = 30, nullable = false)
//    private String taiKhoanThanhToan; // FK
//
//    @NotNull
//    @Column(name = "CongThanhToan", length = 30, nullable = false)
//    private String congThanhToan; // FK

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "KhachHang", nullable = false),
            @JoinColumn(name = "TaiKhoanThanhToan", nullable = false),
            @JoinColumn (name = "CongThanhToan", nullable = false)
    })
    @JsonIgnoreProperties(value = {
            "giaoDichSet"
    })
    private PhuongThucThanhToan phuongThucThanhToan;

    @OneToMany(mappedBy = "giaoDich", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {
            "giaoDich", "hinhThucVanChuyen",
            "thongTinVanChuyenSet", "khieuNaiDonHangSet"
    })
    private Set<DonHang> donHangSet = new HashSet<>();
}
