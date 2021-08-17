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
@Table(name = "ThongTinVanChuyen")
@Getter
@Setter
@NoArgsConstructor
public class ThongTinVanChuyen implements Serializable {

    @EmbeddedId
    @NotNull
    private ThongTinVanChuyenID thongTinVanChuyenID;

    @Column(name="TrangThaiVanChuyen", length=200)
    private String trangThaiVanChuyen;

    @Column(name="ThoiGianVanChuyen")
    private Instant thoiGianVanChuyen;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "NhanVienGiaoHang", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "khieuNaiDonHangSet", "thongTinVanChuyenSet"
    })
    private NhanVien nhanVienGiaoHang;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "DonHang", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "giaoDich",
            "thongTinVanChuyenSet", "khieuNaiDonHangSet"
    }, allowSetters = true)
    private DonHang donHang;

    @Getter
    @Setter
    @Embeddable
    public static class ThongTinVanChuyenID implements Serializable {
        @NotNull
        @Column(name="NhanVienGiaoHang", nullable = false)
        private Long nhanVienGiaoHang; // FK

        @NotNull
        @Column(name="DonHang", nullable = false)
        private Long donHang; // FK

        public ThongTinVanChuyenID() {
        }
    }

}
