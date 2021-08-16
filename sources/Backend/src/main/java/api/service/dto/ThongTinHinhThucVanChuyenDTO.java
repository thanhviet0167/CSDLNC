package api.service.dto;

import api.domain.HinhThucVanChuyen;
import api.domain.ThongTinHinhThucVanChuyen;
import api.service.mapper.HinhThucVanChuyenMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class ThongTinHinhThucVanChuyenDTO {

    private Long maHinhThucVanChuyen;
    private Integer phamViVanChuyen;
    private Long phiGiaoHang;
    private Instant thoiGianGiaoHang;

    private HinhThucVanChuyenDTO hinhThucVanChuyen;

    public ThongTinHinhThucVanChuyenDTO (ThongTinHinhThucVanChuyen thongTinHinhThucVanChuyen, HinhThucVanChuyenMapper hinhThucVanChuyenMapper) {
        this.maHinhThucVanChuyen = thongTinHinhThucVanChuyen.getThongTinHinhThucVanChuyenID().getMaHinhThucVanChuyen();
        this.phamViVanChuyen = thongTinHinhThucVanChuyen.getThongTinHinhThucVanChuyenID().getPhamViVanChuyen();

        this.phiGiaoHang = thongTinHinhThucVanChuyen.getPhiGiaoHang();
        this.thoiGianGiaoHang = thongTinHinhThucVanChuyen.getThoiGianGiaoHang();

        this.hinhThucVanChuyen = hinhThucVanChuyenMapper.fromModelToDto(thongTinHinhThucVanChuyen.getHinhThucVanChuyen());
    }
}
