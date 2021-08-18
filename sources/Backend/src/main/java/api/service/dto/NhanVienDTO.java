package api.service.dto;

import api.domain.KhieuNaiDonHang;
import api.domain.NhanVien;
import api.domain.ThongTinVanChuyen;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class NhanVienDTO {

    private Long maNhanVien;
    private String hoTen;
    private Instant ngaySinh;
    private String diaChi;
    private String emailCaNhan;

    @Min(0)
    @NotNull
    private Integer loaiNhanVien;

    private Set<KhieuNaiDonHang> khieuNaiDonHangSet = new HashSet<>();
    private Set<ThongTinVanChuyen> thongTinVanChuyenSet = new HashSet<>();

    public NhanVienDTO (NhanVien nhanVien) {
        this.maNhanVien = nhanVien.getMaNhanVien();
        this.hoTen = nhanVien.getHoTen();
        this.ngaySinh = nhanVien.getNgaySinh();
        this.diaChi = nhanVien.getDiaChi();
        this.emailCaNhan = nhanVien.getEmailCaNhan();
        this.loaiNhanVien = nhanVien.getLoaiNhanVien();

        this.khieuNaiDonHangSet.addAll(nhanVien.getKhieuNaiDonHangSet());
        this.thongTinVanChuyenSet.addAll(nhanVien.getThongTinVanChuyenSet());
    }

}
