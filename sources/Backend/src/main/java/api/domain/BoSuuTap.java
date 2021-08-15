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
@Table(name = "BoSuuTap")
@Getter
@Setter
@NoArgsConstructor
public class BoSuuTap implements Serializable {

    @EmbeddedId
    @NotNull
    private BoSuuTapID boSuuTapID;

    @NotNull
    @Column(name="TenBoSuuTap", length=100, nullable = false)
    private String tenBoSuuTap;

    @OneToMany(mappedBy = "boSuuTap", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {
            "boSuuTap","nhaCungCap",
            "yeuThichSanPhamSet", "apDungVoucherSet",
            "tangKemVoucherSet", "xemSanPhamSet",
            "chiTietGioHangSet", "sanPhamTangKemChiTietQuaTangSet"
    }, allowSetters = true)
    private Set<SanPham> sanPhamSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "Username", nullable = false)
    @JsonIgnoreProperties(value = {
            "boSuuTapSet", "sanPhamSet",
            "theoDoiNhaCungCapSet", "voucherSet",
            "gioHangSet"
    })
    private NhaCungCap nhaCungCap;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class BoSuuTapID implements Serializable {
        @NotNull
        @Column(name="Username", length=20, nullable = false)
        private String username; // FK

        @NotNull
        @Column(name="STT", nullable = false)
        private Integer stt;
    }

}
