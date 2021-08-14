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
@Table(name = "ThongTinThanhToan")
@Getter
@Setter
@NoArgsConstructor
public class ThongTinThanhToan implements Serializable {

    @EmbeddedId
    @NotNull
    private ThongTinThanhToanID thongTinThanhToanID;

    @NotNull
    @Column(name="LoaiPhuongThucThanhToan", nullable = false)
    private Integer loaiPhuongThucThanhToan;

    @NotNull
    @Column(name="HoTenChuTaiKhoan", length=50, nullable = false)
    private String hoTenChuTaiKhoan;

    @Column(name="ChiNhanh", length=100)
    private String chiNhanh;

    @Column(name="LoaiThe", length=50)
    private String loaiThe;

    @NotNull
    @Column(name="NgayHetHan", nullable = false)
    private Instant ngayHetHan;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class ThongTinThanhToanID implements Serializable {
        @NotNull
        @Column(name="TaiKhoanThanhToan", length=30, nullable = false)
        private String taiKhoanThanhToan;

        @NotNull
        @Column(name="CongThanhToan", length = 30, nullable = false)
        private String CongThanhToan;
    }

}
