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

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "MaHinhThucVanChuyen", insertable = false, updatable = false, nullable = false)
    @JsonIgnoreProperties(value = {
            "donHangSet", "thongTinHinhThucVanChuyenSet"
    })
    private HinhThucVanChuyen hinhThucVanChuyen;

    @Getter
    @Setter
    @Embeddable
    public static class ThongTinHinhThucVanChuyenID implements Serializable {
        @NotNull
        @Column(name="MaHinhThucVanChuyen", nullable = false)
        private Long maHinhThucVanChuyen;

        @NotNull
        @Column(name="PhamViVanChuyen", nullable = false)
        private Integer phamViVanChuyen;

        public ThongTinHinhThucVanChuyenID() {
        }
    }

}
