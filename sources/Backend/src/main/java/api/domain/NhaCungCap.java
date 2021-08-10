package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "NhaCungCap")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class NhaCungCap extends KhachHang {

    @NotNull
    @Column(name = "TenNhaCungCap", length = 100, nullable = false)
    private String tenNhaCungCap;

    @Column(name = "MoTa", length = 300)
    private String moTa;

    @NotNull
    @Column(name = "NgayThamGia", nullable = false)
    private Instant ngayThamGia;

    @NotNull
    @Column(name = "SDT_LienLac", length = 11, nullable = false)
    private String sdtLienLac;

    @NotNull
    @Column(name = "DiaChi", length = 100, nullable = false)
    private String diaChi;

    @NotNull
    @Column(name = "MaTinhThanhPho", nullable = false)
    private Integer tinhThanhPho; // FK
}
