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

@Entity
@Table(name = "ChiTietVoucher")
@Getter
@Setter
@NoArgsConstructor
public class ChiTietVoucher implements Serializable {

    @EmbeddedId
    @NotNull
    private ChiTietVoucherID chiTietVoucherID;

    @Column(name="PhanTramGiamGia", nullable = false)
    private Float phanTramGiamGia;

    @Column(name="SoLuongApDungToiDa", nullable = false)
    private Integer soLuongApDungToiDa;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "MaVoucher", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "chiTietVoucherSet", "gioHangSet",
            "voucherApDungSet"
    }, allowSetters = true)
    private Voucher voucher;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "SanPhamTangKem", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "yeuThichSanPhamSet", "apDungVoucherSet",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    private SanPham sanPhamTangKem;

    @Getter
    @Setter
    @Embeddable
    public static class ChiTietVoucherID implements Serializable {
        @NotNull
        @Column(name="MaVoucher", nullable = false)
        private Long maVoucher; // FK

        @NotNull
        @Column(name="SanPhamTangKem", nullable = false)
        private Long sanPhamTangKem; // FK

        public ChiTietVoucherID() {
        }
    }

}
