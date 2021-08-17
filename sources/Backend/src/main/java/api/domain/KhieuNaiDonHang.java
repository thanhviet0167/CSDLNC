package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "KhieuNaiDonHang")
@Getter
@Setter
@NoArgsConstructor
public class KhieuNaiDonHang implements Serializable {

    @EmbeddedId
    @NotNull
    private KhieuNaiDonHangID khieuNaiDonHangID;

    @NotNull
    @Column(name = "NgayTaoKhieuNai", nullable = false)
    private Instant ngayTaoKhieuNai;

    @NotNull
    @Column(name = "NoiDungKhieuNai", length = 500, nullable = false)
    private Boolean noiDungKhieuNai;

    @Max(2)
    @Min(0)
    @NotNull
    @Column(name = "TrangThaiXuLy", nullable = false)
    private Integer trangThaiXuLy;

    @Max(5)
    @Min(0)
    @Column(name = "MucDoHaiLongKhachHang", nullable = false)
    private Integer mucDoHaiLongKhachHang;

//    @Column(name="NhanVienXuLy")
//    private Long nhanVienXuLy; // FK

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "NhanVienXuLy")
    @JsonIgnoreProperties(value = {
            "khieuNaiDonHangSet", "thongTinVanChuyenSet"
    })
    private NhanVien nhanVienXuLy;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "DonHang", insertable = false, updatable = false, nullable = false)
    @JsonIgnoreProperties({
            "khieuNaiDonHangSet"
    })
    private DonHang donHang;

    @Getter
    @Setter
    @Embeddable
    public static class KhieuNaiDonHangID implements Serializable {
        @NotNull
        @Column(name="DonHang", nullable = false)
        private Long donHang; // FK

        @NotNull
        @Column(name="STT", nullable = false)
        private Integer stt;

        public KhieuNaiDonHangID() {
        }
    }

}
