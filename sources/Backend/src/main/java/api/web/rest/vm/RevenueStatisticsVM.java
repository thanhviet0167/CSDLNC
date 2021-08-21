package api.web.rest.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RevenueStatisticsVM implements Serializable {
    String nhaCungCap;
    List<RevenueStatisticItem> thongKe;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class RevenueStatisticItem {
        String thoiGian;
        Long tongDoanhThu;
        Integer soDon;
    }
}
