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
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "CongThanhToan", insertable = false, updatable = false, nullable = false)
    @JsonIgnoreProperties(value = {"thongTinThanhToanSet"}, allowSetters = true)
    private ThongTinCongThanhToan thongTinCongThanhToan;

    @OneToMany(mappedBy = "thongTinThanhToan", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {"thongTinThanhToan", "giaoDichSet"}, allowSetters = true)
    private Set<PhuongThucThanhToan> phuongThucThanhToanSet = new HashSet<>();

    @Getter
    @Setter
    @Embeddable
    public static class ThongTinThanhToanID implements Serializable {
        @NotNull
        @Column(name="TaiKhoanThanhToan", length=30, nullable = false)
        private String taiKhoanThanhToan;

        @NotNull
        @Column(name="CongThanhToan", length = 30, nullable = false)
        private String congThanhToan;

        public ThongTinThanhToanID() {
        }
    }

}
