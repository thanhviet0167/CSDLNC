package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "ChiTietGioHang")
@Getter
@Setter
@NoArgsConstructor
public class ChiTietGioHang implements Serializable {

    @EmbeddedId
    @NotNull
    private ChiTietGioHangID chiTietGioHangID;

    @NotNull
    @Column(name="SoLuongMua", nullable = false)
    private Integer soLuongMua;

    @NotNull
    @Column(name="GiaBanThucTe", nullable = false)
    private Long giaBanThucTe;

    @Column(name="GiaGiam")
    private Long giaGiam;

    @Min(0)
    @Max(5)
    @Column(name="DanhGia")
    private Integer danhGia;

    @Column(name="BinhLuan", length=500)
    private String binhLuan;

    @Column(name="ThoiGianDanhGia")
    private Instant thoiGianDanhGia;

    @ManyToOne
    @JoinColumn(name = "MaGioHang")
    @JsonIgnoreProperties(value = {
            "chiTietGioHangSet",
            "donHangSet"
    })
    // voucherApDungSet
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "MaSanPham")
    @JsonIgnoreProperties(value = {
            "yeuThichSanPhamSet",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    // apDungVoucherSet
    private SanPham sanPham;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class ChiTietGioHangID implements Serializable {
        @NotNull
        @Column(name="MaGioHang", nullable = false)
        private Long maGioHang;

        @NotNull
        @Column(name="MaSanPham", nullable = false)
        private Long maSanPham;
    }

}
