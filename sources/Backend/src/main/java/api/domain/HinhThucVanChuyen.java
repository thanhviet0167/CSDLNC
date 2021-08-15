package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "HinhThucVanChuyen")
@Getter
@Setter
@NoArgsConstructor
public class HinhThucVanChuyen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MaHinhThucVanChuyen", unique = true, nullable = false)
    private Long maHinhThucVanChuyen;

    @NotNull
    @Column(name = "TenHinhThucVanChuyen", length = 50, nullable = false)
    private String tenHinhThucVanChuyen;

    @OneToMany(mappedBy = "hinhThucVanChuyen", fetch = FetchType.EAGER)
    private Set<ThongTinHinhThucVanChuyen> thongTinHinhThucVanChuyenSet = new HashSet<>();

    @OneToMany(mappedBy = "hinhThucVanChuyen")
    @JsonIgnoreProperties(value = {
            "hinhThucVanChuyen", "giaoDich",
            "khieuNaiDonHangSet",
    })
    private Set<DonHang> donHangSet = new HashSet<>();
}
