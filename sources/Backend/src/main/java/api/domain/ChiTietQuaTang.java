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
@Table(name = "ChiTietQuaTang")
@Getter
@Setter
@NoArgsConstructor
public class ChiTietQuaTang implements Serializable {

    @EmbeddedId
    @NotNull
    private ChiTietQuaTangID chiTietQuaTangID;

    @NotNull
    @Column(name="GiaBanTangKem", nullable = false)
    private Long giaBanTangKem;

    @NotNull
    @Column(name="SoLuongTangKem", nullable = false)
    private Integer soLuongTangKem;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
            @JoinColumn(name = "MaVoucher", referencedColumnName = "MaVoucher", insertable = false, updatable = false),
            @JoinColumn(name = "MaGioHang", referencedColumnName = "MaGioHang", insertable = false, updatable = false)
    })
    @JsonIgnoreProperties(value = {
            "chiTietQuaTangSet"
    }, allowSetters = true)
    private VoucherApDung voucherApDung;

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
    public static class ChiTietQuaTangID implements Serializable {
        @NotNull
        @Column(name="MaVoucher", nullable = false)
        private Long maVoucher; // FK

        @NotNull
        @Column(name="MaGioHang", nullable = false)
        private Long maGioHang; // FK

        @NotNull
        @Column(name="SanPhamTangKem", nullable = false)
        private Long sanPhamTangKem; // FK

        public ChiTietQuaTangID() {
        }
    }

}
