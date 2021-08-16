package api.service.dto;

import api.domain.KhachHang;
import api.domain.SanPham;
import api.domain.SanPhamYeuThich;
import api.service.mapper.KhachHangMapper;
import api.service.mapper.SanPhamMapper;
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
public class SanPhamYeuThichDTO {
    private Instant thoiGian;

    private KhachHangDTO khachHang;
    private SanPhamDTO sanPham;

    public SanPhamYeuThichDTO(SanPhamYeuThich sanPhamYeuThich, KhachHangMapper khachHangMapper, SanPhamMapper sanPhamMapper) {
        this.thoiGian = sanPhamYeuThich.getThoiGian();
        this.khachHang = khachHangMapper.fromModelToDto(sanPhamYeuThich.getKhachHang());
        this.sanPham = sanPhamMapper.fromModelToDto(sanPhamYeuThich.getSanPham());
    }
}
