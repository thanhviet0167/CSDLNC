package api.service.dto;

import api.domain.GioHang;
import api.domain.KhachHang;
import api.domain.SoDiaChi;
import api.domain.TinhThanhPho;
import api.service.mapper.KhachHangMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
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
public class SoDiaChiDTO {

    private String hoTenNguoiNhan;
    private String diaChi;

    private TinhThanhPhoDTO tinhThanhPho;

    private String sdt;

    private KhachHangDTO khachHang;
    private Integer stt;

    private Set<GioHang> gioHangSet = new HashSet<>();

    public SoDiaChiDTO(SoDiaChi soDiaChi, KhachHangMapper khachHangMapper, TinhThanhPhoMapper tinhThanhPhoMapper) {
        this.hoTenNguoiNhan = soDiaChi.getHoTenNguoiNhan();
        this.diaChi = soDiaChi.getDiaChi();
        this.tinhThanhPho = tinhThanhPhoMapper.fromModelToDto(soDiaChi.getTinhThanhPho());

        this.sdt = soDiaChi.getSdt();
        this.khachHang = khachHangMapper.fromModelToDto(soDiaChi.getKhachHang());
        this.stt = soDiaChi.getSoDiaChiID().getStt();
    }
}
