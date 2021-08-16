package api.service.dto;

import api.domain.ChiTietQuaTang;
import api.domain.SanPham;
import api.domain.VoucherApDung;
import api.service.mapper.SanPhamMapper;
import api.service.mapper.VoucherApDungMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ChiTietQuaTangDTO {

    private Long giaBanTangKem;

    private Integer soLuongTangKem;

    private VoucherApDungDTO voucherApDung;

    private SanPhamDTO sanPhamTangKem;

    public ChiTietQuaTangDTO (ChiTietQuaTang chiTietQuaTang, VoucherApDungMapper voucherApDungMapper, SanPhamMapper sanPhamMapper) {
        this.giaBanTangKem = chiTietQuaTang.getGiaBanTangKem();
        this.soLuongTangKem = chiTietQuaTang.getSoLuongTangKem();

        this.voucherApDung = voucherApDungMapper.fromModelToDto(chiTietQuaTang.getVoucherApDung());
        this.sanPhamTangKem = sanPhamMapper.fromModelToDto(chiTietQuaTang.getSanPhamTangKem());

    }

}
