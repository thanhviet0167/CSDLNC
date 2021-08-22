package api.web.rest.vm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class SuccessOrderStatisticsVM implements Serializable {
    Integer nam;
    Integer soLuongDonHangThanhCong;
    Integer soLuongDonHang;
}
