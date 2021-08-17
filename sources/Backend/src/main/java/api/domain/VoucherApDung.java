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
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "MaGioHang", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "voucherApDungSet", "donHangSet",
            "chiTietGioHangSet"
    })
    private GioHang gioHang;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "MaVoucher", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "gioHangSet",
            "voucherApDungSet"
    })
    // chiTietVoucherSet
    private Voucher voucher;

    @OneToMany(mappedBy = "voucherApDung", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "voucherApDung"
    })
    private Set<ChiTietQuaTang> chiTietQuaTangSet = new HashSet<>();

    @Getter
    @Setter
    @Embeddable
    public static class VoucherApDungID implements Serializable {
        @NotNull
        @Column(name="MaVoucher", nullable = false)
        private Long maVoucher; // FK

        @NotNull
        @Column(name="MaGioHang", nullable = false)
        private Long maGioHang; // FK

        public VoucherApDungID() {
        }
    }

}
