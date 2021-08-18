package api.web.rest.vm;

import api.domain.GioHang;
import api.domain.HinhThucVanChuyen;
import api.domain.PhuongThucThanhToan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class OrderVM implements Serializable {
    HinhThucVanChuyen hinhThucVanChuyen;
    List<GioHang> gioHangList;
    PhuongThucThanhToan phuongThucThanhToan;
}
