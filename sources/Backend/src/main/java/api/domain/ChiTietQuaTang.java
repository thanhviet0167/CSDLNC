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
    @JoinColumns({
            @JoinColumn(name = "MaVoucher"),
            @JoinColumn(name = "MaGioHang")
    })
    @JsonIgnoreProperties(value = {
            "chiTietQuaTangSet"
    })
    private VoucherApDung voucherApDung;

    @ManyToOne
    @JoinColumn(name = "SanPhamTangKem")
    @JsonIgnoreProperties(value = {
            "yeuThichSanPhamSet", "apDungVoucherSet",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    private SanPham sanPhamTangKem;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class ChiTietQuaTangID implements Serializable {
        @NotNull
        @Column(name="MaVoucher", nullable = false)
        private Long maVoucher; // FK

        @NotNull
        @Column(name="MaGioHang", nullable = false)
        private Long maGioHang; // FK

        @NotNull
        @Column(name="SanPhamTangKem", nullable = false)
        private Long sanPhamTangKem; // FK
    }

}
