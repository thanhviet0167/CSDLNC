package api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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

    @NotNull
    @Column(name = "KhachHang", length = 20, nullable = false)
    private String khachHang; // FK

    @NotNull
    @Column(name = "NhaCungCap", length = 20, nullable = false)
    private String nhaCungCap; // FK

    @NotNull
    @Column(name = "TongTienChuaKhuyenMai", nullable = false)
    private Long tongTienChuaKhuyenMai;

    @NotNull
    @Column(name = "TongTienQuaTang", nullable = false)
    private Long tongTienQuaTang;

    @NotNull
    @Column(name = "TrangThaiDatHang", nullable = false)
    private Boolean trangThaiDatHang;

    @Column(name = "MaVoucher")
    private Long maVoucher; // FK

    @NotNull
    @Column(name = "SoTienGiamThucTe", nullable = false)
    private Long soTienGiamThucTe;

    @Column(name = "STT_SoDiaChi")
    private Integer sttSoDiaChi; // FK

}
