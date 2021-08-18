package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@NoArgsConstructor
public class KhachHang implements Serializable {

    @Id
    @Column(name = "Username", unique=true, nullable = false)
    private String username;

    @JsonIgnore
//    @NotNull
    @Size(min = 8, max = 20)
    @Column(name = "Password", length = 20, nullable = false)
    private String password;

    @Column(name = "HoTenKhachHang", length = 100)
    private String hoTenKhachHang;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "NgaySinh")
    private Instant ngaySinh;

    @Column(name = "AnhDaiDien", length = 100)
    private String anhDaiDien;

//    @NotNull
    @Column(name = "SDT_DangKy", length = 11, nullable = false)
    private String sdtDangKy;

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "khachHang",
            "gioHangSet"
    }, allowSetters = true)
    private Set<SoDiaChi> soDiaChiSet = new HashSet<>();

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {"khachHang", "giaoDichSet"}, allowSetters = true)
    private Set<PhuongThucThanhToan> phuongThucThanhToanSet = new HashSet<>();

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "khachHang"
    })
    private Set<SanPhamYeuThich> sanPhamYeuThichSet = new HashSet<>();

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "khachHang"
    })
    private Set<TheoDoiNhaCungCap> theoDoiNhaCungCapSet = new HashSet<>();

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "khachHang"
    })
    private Set<XemSanPham> xemSanPhamSet = new HashSet<>();

    @OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "khachHang"
    })
    private Set<GioHang> gioHangSet = new HashSet<>();

    public KhachHang(String username) {
        this.username = username;
    }
}
