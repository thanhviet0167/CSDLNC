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
@Table(name = "TheoDoiNhaCungCap")
@Getter
@Setter
@NoArgsConstructor
public class TheoDoiNhaCungCap implements Serializable {

    @EmbeddedId
    @NotNull
    private TheoDoiNhaCungCapID theoDoiNhaCungCapID;

    @NotNull
    @Column(name="NgayTheoDoi", nullable = false)
    private Instant ngayTheoDoi;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "maNhaCungCap", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "boSuuTapSet", "sanPhamSet",
            "theoDoiNhaCungCapSet", "voucherSet",
            "gioHangSet"
    })
    private NhaCungCap nhaCungCap;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "maKhachHang", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {
            "soDiaChiSet", "phuongThucThanhToanSet",
            "sanPhamYeuThichSet", "theoDoiNhaCungCapSet",
            "xemSanPhamSet", "gioHangSet"
    }, allowSetters = true)
    private KhachHang khachHang;

    @Getter
    @Setter
    @Embeddable
    public static class TheoDoiNhaCungCapID implements Serializable {
        @NotNull
        @Column(name="MaKhachHang", length=20, nullable = false)
        private String maKhachHang; // FK

        @NotNull
        @Column(name="MaNhaCungCap", length=20, nullable = false)
        private String maNhaCungCap; // FK

        public TheoDoiNhaCungCapID() {
        }
    }

}
