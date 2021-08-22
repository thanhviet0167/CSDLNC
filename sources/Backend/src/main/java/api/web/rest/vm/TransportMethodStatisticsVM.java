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
public class TransportMethodStatisticsVM implements Serializable {
    private String tuNgay;
    private String denNgay;

    List<TransportMethodItem> hinhThucVanChuyen;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class TransportMethodItem {
        Long maHinhThucVanChuyen;
        String tenHinhThucVanChuyen;
        Integer soLuong;
    }
}
