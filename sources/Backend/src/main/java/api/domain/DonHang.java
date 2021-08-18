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
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DonHang")
@Getter
@Setter
@NoArgsConstructor
public class DonHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MaDonHang", unique = true, nullable = false)
    private Long maDonHang;

    @NotNull
    @Column(name = "TrangThaiThanhToan", nullable = false)
    private Boolean trangThaiThanhToan;

    @NotNull
    @Column(name = "NgayDat", nullable = false)
    private Instant ngayDat;

    @NotNull
    @Column(name = "ThanhTien", nullable = false)
    private Long thanhTien;

    @NotNull
    @Column(name = "PhiVanChuyen", nullable = false)
    private Long phiVanChuyen;

//    @NotNull
//    @Column(name = "GioHang", nullable = false)
//    private Long gioHang; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "GioHang")
    @JsonIgnoreProperties(value = {
            "donHangSet"
    })
    private GioHang gioHang;

//    @Column(name = "GiaoDich")
//    private Long giaoDich; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "MaGiaoDich")
    @JsonIgnoreProperties(value = {
            "donHangSet"
    })
    private GiaoDich giaoDich;

//    @NotNull
//    @Column(name = "HinhThucVanChuyen", nullable = false)
//    private Long hinhThucVanChuyen; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "HinhThucVanChuyen", nullable = false)
    @JsonIgnoreProperties(value = {
            "donHangSet"
    })
    private HinhThucVanChuyen hinhThucVanChuyen;

    @OneToMany(mappedBy = "donHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {"donHang"})
    private Set<ThongTinVanChuyen> thongTinVanChuyenSet = new HashSet<>();

    @OneToMany(mappedBy = "donHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "donHang"
    })
    private Set<KhieuNaiDonHang> khieuNaiDonHangSet = new HashSet<>();

}
