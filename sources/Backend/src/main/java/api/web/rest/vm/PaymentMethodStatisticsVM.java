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
public class PaymentMethodStatisticsVM implements Serializable {
    private String tuNgay;
    private String denNgay;

    List<PaymentMethodItem> congThanhToan;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class PaymentMethodItem {
        String maCongThanhToan;
        String tenCongThanhToan;
        Integer soLuong;
    }
}