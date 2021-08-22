package api.web.rest.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StoreStatisticsVM {
    String loai;
    List<StoreStatisticItem> nhaCungCap;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class StoreStatisticItem {
        String maNhaCungCap;
        Integer duLieu;
    }
}
