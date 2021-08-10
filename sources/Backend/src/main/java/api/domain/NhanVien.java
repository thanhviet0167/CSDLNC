package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class NhanVien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhanVien", unique=true, nullable = false)
    private Long maNhanVien;

    @NotNull
    @Column(name = "HoTen", length = 100, nullable = false)
    private String hoTen;

    @NotNull
    @Column(name = "NgaySinh", nullable = false)
    private Instant ngaySinh;

    @NotNull
    @Column(name = "DiaChi", length = 100, nullable = false)
    private Instant diaChi;

    @NotNull
    @Column(name = "EmailCaNhan", length = 50)
    private String emailCaNhan;

    @Min(0)
    @NotNull
    @Column(name = "LoaiNhanVien")
    private Integer loaiNhanVien;
}
