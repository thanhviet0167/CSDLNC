package api.web.rest.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class ProductStatisticsVM implements Serializable {
    String loai;
    List<ProductStatisticItem> sanPham;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class ProductStatisticItem {
        Long maSanPham;
        String tenSanPham;
        Integer soLuong;
    }
}
