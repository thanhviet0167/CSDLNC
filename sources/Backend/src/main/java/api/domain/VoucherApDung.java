package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VoucherApDung")
@Getter
@Setter
@NoArgsConstructor
public class VoucherApDung implements Serializable {

    @EmbeddedId
    @NotNull
    private VoucherApDungID voucherApDungID;

    @ManyToOne
    @JoinColumn(name = "MaGioHang")
    @JsonIgnoreProperties(value = {
            "voucherApDungSet", "donHangSet",
            "chiTietGioHangSet"
    })
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "MaVoucher")
    @JsonIgnoreProperties(value = {
            "gioHangSet",
            "voucherApDungSet"
    })
    // chiTietVoucherSet
    private Voucher voucher;

    @OneToMany(mappedBy = "voucherApDung")
    @JsonIgnoreProperties(value = {
            "voucherApDung"
    })
    private Set<ChiTietQuaTang> chiTietQuaTangSet = new HashSet<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class VoucherApDungID implements Serializable {
        @NotNull
        @Column(name="MaVoucher", nullable = false)
        private Long maVoucher; // FK

        @NotNull
        @Column(name="MaGioHang", nullable = false)
        private Long maGioHang; // FK
    }

}
