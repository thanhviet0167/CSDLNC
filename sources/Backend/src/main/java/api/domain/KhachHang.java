package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class KhachHang implements Serializable {

    @Id
    @Column(name = "Username", unique=true, nullable = false)
    private String username;

    @JsonIgnore
    @NotNull
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

    @NotNull
    @Column(name = "SDT_DangKy", length = 11, nullable = false)
    private String sdtDangKy;

    public KhachHang(String username) {
        this.username = username;
    }
}
