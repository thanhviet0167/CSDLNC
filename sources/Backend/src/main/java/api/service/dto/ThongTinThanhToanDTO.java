package api.service.dto;

import api.domain.PhuongThucThanhToan;
import api.domain.ThongTinCongThanhToan;
import api.domain.ThongTinThanhToan;
import api.service.mapper.ThongTinCongThanhToanMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ThongTinThanhToanDTO {
    private String taiKhoanThanhToan;
    private String congThanhToan;
    private Integer loaiPhuongThucThanhToan;
    private String hoTenChuTaiKhoan;
    private String chiNhanh;
    private String loaiThe;
    private Instant ngayHetHan;

    private ThongTinCongThanhToanDTO thongTinCongThanhToan;

    private Set<PhuongThucThanhToan> phuongThucThanhToanSet = new HashSet<>();

    public ThongTinThanhToanDTO(ThongTinThanhToan thongTinThanhToan, ThongTinCongThanhToanMapper thongTinCongThanhToanMapper) {
        this.taiKhoanThanhToan = thongTinThanhToan.getThongTinThanhToanID().getTaiKhoanThanhToan();
        this.congThanhToan = thongTinThanhToan.getThongTinThanhToanID().getCongThanhToan();
        this.loaiPhuongThucThanhToan = thongTinThanhToan.getLoaiPhuongThucThanhToan();
        this.hoTenChuTaiKhoan = thongTinThanhToan.getHoTenChuTaiKhoan();
        this.chiNhanh = thongTinThanhToan.getChiNhanh();
        this.loaiThe = thongTinThanhToan.getLoaiThe();
        this.ngayHetHan = thongTinThanhToan.getNgayHetHan();

        this.thongTinCongThanhToan = thongTinCongThanhToanMapper.fromModelToDto(thongTinThanhToan.getThongTinCongThanhToan());

        phuongThucThanhToanSet.addAll(thongTinThanhToan.getPhuongThucThanhToanSet());
    }
}
