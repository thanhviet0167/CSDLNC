package api.service.dto;

import api.domain.ThongTinCongThanhToan;
import api.domain.ThongTinThanhToan;
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
public class ThongTinCongThanhToanDTO {

    private String maCongThanhToan;
    private String tenCongThanhToan;

    private Set<ThongTinThanhToan> thongTinThanhToanSet = new HashSet<>();

    public ThongTinCongThanhToanDTO (ThongTinCongThanhToan thongTinCongThanhToan) {
        this.maCongThanhToan = thongTinCongThanhToan.getMaCongThanhToan();
        this.tenCongThanhToan = thongTinCongThanhToan.getTenCongThanhToan();

        this.thongTinThanhToanSet.addAll(thongTinCongThanhToan.getThongTinThanhToanSet());
    }

}
