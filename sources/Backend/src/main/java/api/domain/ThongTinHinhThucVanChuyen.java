package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "ThongTinHinhThucVanChuyen")
@Getter
@Setter
@NoArgsConstructor
public class ThongTinHinhThucVanChuyen implements Serializable {

    @EmbeddedId
    @NotNull
    private ThongTinHinhThucVanChuyenID thongTinHinhThucVanChuyenID;

    @NotNull
    @Column(name="PhiGiaoHang")
    private Long phiGiaoHang;

    @NotNull
    @Column(name="ThoiGianGiaoHang")
    private Instant thoiGianGiaoHang;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class ThongTinHinhThucVanChuyenID implements Serializable {
        @NotNull
        @Column(name="MaHinhThucVanChuyen", nullable = false)
        private Long maHinhThucVanChuyen;

        @NotNull
        @Column(name="PhamViVanChuyen", nullable = false)
        private Integer phamViVanChuyen;
    }

}
