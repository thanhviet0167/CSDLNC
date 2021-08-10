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
import java.time.Instant;

@Entity
@Table(name = "GiaoDich")
@Getter
@Setter
@NoArgsConstructor
public class GiaoDich implements Serializable {

    @Id
    @NotNull
    @Column(name = "MaGiaoDich", unique = true, nullable = false)
    private Long maGiaoDich;

    @NotNull
    @Column(name = "TongTien", nullable = false)
    private Long tongTien;

    @Column(name = "TrangThaiThanhToan", nullable = false)
    private Boolean trangThaiThanhToan;

    @NotNull
    @Column(name = "KhachHang", length = 20, nullable = false)
    private String khachHang;

    @NotNull
    @Column(name = "TaiKhoanThanhToan", length = 30, nullable = false)
    private String taiKhoanThanhToan;

    @NotNull
    @Column(name = "CongThanhToan", length = 30, nullable = false)
    private String congThanhToan;

    @NotNull
    @Column(name = "NgayThanhToan", nullable = false)
    private Instant ngayThanhToan;

}
