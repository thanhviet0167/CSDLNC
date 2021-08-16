package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "XemSanPham")
@Getter
@Setter
@NoArgsConstructor
public class XemSanPham implements Serializable {

    @EmbeddedId
    @NotNull
    private XemSanPhamID xemSanPhamID;

    @ManyToOne
    @JoinColumn(name = "sanPham")
    @JsonIgnoreProperties(value = {
            "yeuThichSanPhamSet", "apDungVoucherSet",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "KhachHang")
    @JsonIgnoreProperties(value = {
            "soDiaChiSet", "phuongThucThanhToanSet",
            "sanPhamYeuThichSet", "theoDoiNhaCungCapSet",
            "xemSanPhamSet", "gioHangSet"
    }, allowSetters = true)
    private KhachHang khachHang;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class XemSanPhamID implements Serializable {
        @NotNull
        @Column(name="SanPham", nullable = false)
        private Long sanPham; // FK

        @NotNull
        @Column(name="KhachHang", length=20, nullable = false)
        private String khachHang; // FK

        @NotNull
        @Column(name="ThoiGian", nullable = false)
        private Instant thoiGian;
    }

}
