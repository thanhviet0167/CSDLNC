package api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

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
    @Column(name = "GioHang", nullable = false)
    private Long gioHang; // FK

    @Column(name = "GiaoDich")
    private Long giaoDich;

    @NotNull
    @Column(name = "HinhThucVanChuyen", nullable = false)
    private Long hinhThucVanChuyen;

    @NotNull
    @Column(name = "PhiVanChuyen", nullable = false)
    private Long phiVanChuyen;

}
