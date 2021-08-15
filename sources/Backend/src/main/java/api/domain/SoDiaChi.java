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
@Table(name = "SoDiaChi")
@Getter
@Setter
@NoArgsConstructor
public class SoDiaChi implements Serializable {

    @EmbeddedId
    @NotNull
    private SoDiaChiID soDiaChiID;

    @NotNull
    @Column(name="HoTenNguoiNhan", length=50, nullable = false)
    private String hoTenNguoiNhan;

    @NotNull
    @Column(name="DiaChi", length=100, nullable = false)
    private String diaChi;

//    @NotNull
//    @Column(name="MaTinhThanhPho", nullable = false)
//    private Integer maTinhThanhPho; // FK

    @ManyToOne
    @JoinColumn(name = "MaTinhThanhPho", nullable = false)
    @JsonIgnoreProperties(value = {
            "nhaCungCapSet", "soDiaChiSet"
    }, allowSetters = true)
    private TinhThanhPho tinhThanhPho;

    @NotNull
    @Column(name="SDT", length=11, nullable = false)
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "Username", nullable = false)
    @JsonIgnoreProperties(value = {
            "soDiaChiSet", "phuongThucThanhToanSet",
            "sanPhamYeuThichSet", "theoDoiNhaCungCapSet",
            "xemSanPhamSet", "gioHangSet"
    }, allowSetters = true)
    private KhachHang khachHang;

    @OneToMany(mappedBy = "soDiaChi", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {
            "soDiaChi"
    })
    private Set<GioHang> gioHangSet = new HashSet<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class SoDiaChiID implements Serializable {
        @NotNull
        @Column(name="Username", length=20, nullable = false)
        private String username; // FK

        @NotNull
        @Column(name="STT", nullable = false)
        private Integer stt;
    }

}
