package api.service.dto;

import api.domain.DonHang;
import api.domain.GiaoDich;
import api.domain.PhuongThucThanhToan;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class GiaoDichDTO {
    private Long maGiaoDich;
    private Long tongTien;
    private Boolean trangThaiThanhToan;
    private Instant ngayThanhToan;

    private PhuongThucThanhToanDTO phuongThucThanhToan;

    private Set<DonHang> donHangSet = new HashSet<>();

    public GiaoDichDTO (GiaoDich giaoDich, PhuongThucThanhToanMapper phuongThucThanhToanMapper) {
        this.maGiaoDich = giaoDich.getMaGiaoDich();
        this.tongTien = giaoDich.getTongTien();
        this.trangThaiThanhToan = giaoDich.getTrangThaiThanhToan();
        this.ngayThanhToan = giaoDich.getNgayThanhToan();

        this.phuongThucThanhToan = phuongThucThanhToanMapper.fromModelToDto(giaoDich.getPhuongThucThanhToan());

        donHangSet.addAll(giaoDich.getDonHangSet());
    }

}
