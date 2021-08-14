package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name="NhanVienXuLy")
    private Long nhanVienXuLy; // FK

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

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class KhieuNaiDonHangID implements Serializable {
        @NotNull
        @Column(name="DonHang", nullable = false)
        private Long donHang; // FK

        @NotNull
        @Column(name="STT", nullable = false)
        private Integer stt;
    }

}
