package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "PhuongThucThanhToan")
@Getter
@Setter
@NoArgsConstructor
public class PhuongThucThanhToan implements Serializable {

    @EmbeddedId
    @NotNull
    private PhuongThucThanhToanID boSuuTapID;

    @NotNull
    @Column(name="TinhTrangXacThuc", nullable = false)
    private Boolean tinhTrangXacThuc;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class PhuongThucThanhToanID implements Serializable {
        @NotNull
        @Column(name="Username", length=20, nullable = false)
        private String username;  // FK

        @NotNull
        @Column(name="TaiKhoanThanhToan", length = 30, nullable = false)
        private String taiKhoanThanhToan;

        @NotNull
        @Column(name="CongThanhToan", length = 30, nullable = false)
        private String congThanhToan;


    }

}
