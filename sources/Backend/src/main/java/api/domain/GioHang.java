package api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "GioHang")
@Getter
@Setter
@NoArgsConstructor
public class GioHang implements Serializable {

    @Id
    @NotNull
    @Column(name = "MaGioHang", unique = true, nullable = false)
    private Long maGioHang;

    @NotNull
    @Column(name = "KhachHang", length = 20, nullable = false)
    private String khachHang;

    @NotNull
    @Column(name = "NhaCungCap", length = 20, nullable = false)
    private String nhaCungCap;

    @NotNull
    @Column(name = "TongTienChuaKhuyenMai", nullable = false)
    private Long tongTienChuaKhuyenMai;

    @NotNull
    @Column(name = "TongTienQuaTang", nullable = false)
    private Long tongTienQuaTang;

    @NotNull
    @Column(name = "TrangThaiDatHang", nullable = false)
    private Boolean trangThaiDatHang;

    @Column(name = "KhachHang", length = 20, nullable = false)
    private String khachHang;


}
