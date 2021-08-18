package api.web.rest.vm;

import api.domain.DonHang;
import api.domain.GiaoDich;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CompleteOrderVM implements Serializable {
    List<DonHang> donHangList;
    GiaoDich giaoDich;
}
