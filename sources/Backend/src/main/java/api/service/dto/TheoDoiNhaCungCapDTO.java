package api.service.dto;

import api.domain.KhachHang;
import api.domain.NhaCungCap;
import api.domain.TheoDoiNhaCungCap;
import api.service.mapper.KhachHangMapper;
import api.service.mapper.NhaCungCapMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class TheoDoiNhaCungCapDTO {

    private Instant ngayTheoDoi;

    private NhaCungCapDTO nhaCungCap;
    private KhachHangDTO khachHang;

    public TheoDoiNhaCungCapDTO (TheoDoiNhaCungCap theoDoiNhaCungCap, NhaCungCapMapper nhaCungCapMapper, KhachHangMapper khachHangMapper) {
        this.ngayTheoDoi = theoDoiNhaCungCap.getNgayTheoDoi();
        this.nhaCungCap = nhaCungCapMapper.fromModelToDto(theoDoiNhaCungCap.getNhaCungCap());
        this.khachHang = khachHangMapper.fromModelToDto(theoDoiNhaCungCap.getKhachHang());
    }
}
