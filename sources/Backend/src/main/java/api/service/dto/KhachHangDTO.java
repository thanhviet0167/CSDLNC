package api.service.dto;

import api.domain.KhachHang;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class KhachHangDTO {

    @Size(min = 1,max = 50)
    private String username;

    public KhachHangDTO(KhachHang khachHang) {
        this.username  = khachHang.getUsername();
    }
}
