package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Voucher")
@Getter
@Setter
@NoArgsConstructor
public class Voucher implements Serializable {

    @Id
    @Column(name = "MaVoucher", unique=true, nullable = false)
    private Long maVoucher;

    @NotNull
    @Column(name = "SoLuongVoucher", nullable = false)
    private Integer soLuongVoucher;

    @NotNull
    @Column(name = "NgayBatDau", nullable = false)
    private Instant ngayBatDau;

    @NotNull
    @Column(name = "NgayKetThuc", nullable = false)
    private Instant ngayKetThuc;

    @NotNull
    @Column(name = "LoaiVoucher", nullable = false)
    private Integer loaiVoucher;

    @Column(name = "GiaTriDonHangToiThieu")
    private Long giaTriDonHangToiThieu;

    @Column(name = "PhanTramKhuyenMai")
    private Float phanTramKhuyenMai;

    @Column(name = "SoTienGiamToiDa")
    private Long soTienGiamToiDa;

    @Column(name = "SanPhamApDung")
    private Long sanPhamApDung;

    @Column(name = "NhaCungCap")
    private Long nhaCungCap;
}
