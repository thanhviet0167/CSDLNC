package api.service.dto;

import api.domain.DonHang;
import api.domain.HinhThucVanChuyen;
import api.domain.ThongTinHinhThucVanChuyen;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class HinhThucVanChuyenDTO {

    private Long maHinhThucVanChuyen;
    private String tenHinhThucVanChuyen;

    private Set<ThongTinHinhThucVanChuyen> thongTinHinhThucVanChuyenSet = new HashSet<>();
    private Set<DonHang> donHangSet = new HashSet<>();

    public HinhThucVanChuyenDTO(HinhThucVanChuyen hinhThucVanChuyen) {
        this.maHinhThucVanChuyen = hinhThucVanChuyen.getMaHinhThucVanChuyen();
        this.tenHinhThucVanChuyen = hinhThucVanChuyen.getTenHinhThucVanChuyen();

        this.thongTinHinhThucVanChuyenSet.addAll(hinhThucVanChuyen.getThongTinHinhThucVanChuyenSet());
        this.donHangSet.addAll(hinhThucVanChuyen.getDonHangSet());
    }

}
