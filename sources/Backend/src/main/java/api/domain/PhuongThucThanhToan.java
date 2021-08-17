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
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PhuongThucThanhToan")
@Getter
@Setter
@NoArgsConstructor
public class PhuongThucThanhToan implements Serializable {

    @EmbeddedId
    @NotNull
    private PhuongThucThanhToanID phuongThucThanhToanID;

    @NotNull
    @Column(name="TinhTrangXacThuc", nullable = false)
    private Boolean tinhTrangXacThuc;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "Username", insertable = false, updatable = false, nullable = false)
    @JsonIgnoreProperties(value = {
            "soDiaChiSet", "phuongThucThanhToanSet",
            "sanPhamYeuThichSet", "theoDoiNhaCungCapSet",
            "xemSanPhamSet", "gioHangSet"
    }, allowSetters = true)
    private KhachHang khachHang;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
            @JoinColumn(name = "TaiKhoanThanhToan", insertable = false, updatable = false),
            @JoinColumn(name = "CongThanhToan", insertable = false, updatable = false)
    })
    @JsonIgnoreProperties(value = {"phuongThucThanhToanSet"}, allowSetters = true)
    private ThongTinThanhToan thongTinThanhToan;

    @OneToMany(mappedBy = "phuongThucThanhToan", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "donHangSet"
    })
    private Set<GiaoDich> giaoDichSet = new HashSet<>();

    @Getter
    @Setter
    @Embeddable
    public static class PhuongThucThanhToanID implements Serializable {
        @NotNull
        @Column(name="Username", length=20, nullable = false)
        private String username;  // FK

        @NotNull
        @Column(name="TaiKhoanThanhToan", length = 30, nullable = false)
        private String taiKhoanThanhToan;

        @NotNull
        @Column(name="CongThanhToan", length = 30, nullable = false)
        private String congThanhToan;

        public PhuongThucThanhToanID() {
        }
    }

}
