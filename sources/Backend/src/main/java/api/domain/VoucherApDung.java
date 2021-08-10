package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "VoucherApDung")
@Getter
@Setter
@NoArgsConstructor
public class VoucherApDung implements Serializable {

    @EmbeddedId
    @NotNull
    private VoucherApDungID voucherApDungID;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class VoucherApDungID implements Serializable {
        @NotNull
        @Column(name="MaVoucher", nullable = false)
        private Long maVoucher;

        @NotNull
        @Column(name="MaGioHang", nullable = false)
        private Long maGioHang; // FK
    }

}
