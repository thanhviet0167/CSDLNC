package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "SanPhamYeuThich")
@Getter
@Setter
@NoArgsConstructor
public class SanPhamYeuThich implements Serializable {

    @EmbeddedId
    @NotNull
    private SanPhamYeuThichID sanPhamYeuThichID;

    @NotNull
    @Column(name="ThoiGian", nullable = false)
    private Instant thoiGian;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "KhachHang", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "soDiaChiSet", "phuongThucThanhToanSet",
            "sanPhamYeuThichSet", "theoDoiNhaCungCapSet",
            "xemSanPhamSet", "gioHangSet"
    }, allowSetters = true)
    private KhachHang khachHang;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "SanPham", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "yeuThichSanPhamSet",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    // apDungVoucherSet
    private SanPham sanPham;

    @Getter
    @Setter
    @Embeddable
    public static class SanPhamYeuThichID implements Serializable {
        @NotNull
        @Column(name="SanPham", nullable = false)
        private Long sanPham; // FK

        @NotNull
        @Column(name="KhachHang", length=20, nullable = false)
        private String khachHang; // FK

        public SanPhamYeuThichID() {
        }
    }

}
