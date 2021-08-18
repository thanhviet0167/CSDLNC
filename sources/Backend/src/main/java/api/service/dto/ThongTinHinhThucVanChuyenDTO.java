package api.service.dto;

import api.domain.ThongTinHinhThucVanChuyen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ThongTinHinhThucVanChuyenDTO {

    private ThongTinHinhThucVanChuyenIDDTO thongTinHinhThucVanChuyenID;

    private HinhThucVanChuyenDTO hinhThucVanChuyen;

    private Integer phamViVanChuyen;
    private Long phiGiaoHang;
    private Integer thoiGianGiaoHang;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ThongTinHinhThucVanChuyenIDDTO {
        private Long maHinhThucVanChuyen;
        private Integer phamViVanChuyen;
    }
}
