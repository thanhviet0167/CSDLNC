package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@NoArgsConstructor
public class NhanVien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhanVien", unique=true, nullable = false)
    private Long maNhanVien;

    @NotNull
    @Column(name = "HoTenNhanVien", length = 100, nullable = false)
    private String hoTen;

    @NotNull
    @Column(name = "NgaySinh", nullable = false)
    private Instant ngaySinh;

    @NotNull
    @Column(name = "DiaChi", length = 100, nullable = false)
    private String diaChi;

    @Column(name = "EmailCaNhan", length = 50)
    private String emailCaNhan;

    @Min(0)
    @NotNull
    @Column(name = "LoaiNhanVien")
    private Integer loaiNhanVien;

    @OneToMany(mappedBy = "nhanVienXuLy", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<KhieuNaiDonHang> khieuNaiDonHangSet = new HashSet<>();

    @OneToMany(mappedBy = "nhanVienGiaoHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<ThongTinVanChuyen> thongTinVanChuyenSet = new HashSet<>();
}
