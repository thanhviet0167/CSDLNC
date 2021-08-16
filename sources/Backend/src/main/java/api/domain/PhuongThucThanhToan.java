package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private PhuongThucThanhToanID boSuuTapID;

    @NotNull
    @Column(name="TinhTrangXacThuc", nullable = false)
    private Boolean tinhTrangXacThuc;

    @ManyToOne
    @JoinColumn(name = "Username", nullable = false)
    @JsonIgnoreProperties(value = {
            "soDiaChiSet", "phuongThucThanhToanSet",
            "sanPhamYeuThichSet", "theoDoiNhaCungCapSet",
            "xemSanPhamSet", "gioHangSet"
    }, allowSetters = true)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "TaiKhoanThanhToan"),
            @JoinColumn(name = "CongThanhToan")
    })
    @JsonIgnoreProperties(value = {"phuongThucThanhToanSet"}, allowSetters = true)
    private ThongTinThanhToan thongTinThanhToan;

    @OneToMany(mappedBy = "phuongThucThanhToan", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {
            "donHangSet"
    })
    private Set<GiaoDich> giaoDichSet = new HashSet<>();

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
