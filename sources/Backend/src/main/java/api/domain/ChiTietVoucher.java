package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotNull
    @Column(name="PhanTramGiamGia", nullable = false)
    private Float phanTramGiamGia;

    @NotNull
    @Column(name="SoLuongApDungToiDa", nullable = false)
    private Integer soLuongApDungToiDa;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class ChiTietVoucherID implements Serializable {
        @NotNull
        @Column(name="MaVoucher", nullable = false)
        private Long maVoucher;

        @NotNull
        @Column(name="SanPhamTangKem", nullable = false)
        private Long sanPhamTangKem;
    }

}
