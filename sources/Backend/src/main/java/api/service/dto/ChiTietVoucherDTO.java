package api.service.dto;

import api.domain.ChiTietVoucher;
import api.domain.SanPham;
import api.domain.Voucher;
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
public class ChiTietVoucherDTO {

    private Float phanTramGiamGia;

    private Integer soLuongApDungToiDa;

    private VoucherDTO voucher;

    private SanPhamDTO sanPhamTangKem;

    public ChiTietVoucherDTO(ChiTietVoucher chiTietVoucher, VoucherMapper voucherMapper, SanPhamMapper sanPhamMapper) {
        this.phanTramGiamGia = chiTietVoucher.getPhanTramGiamGia();
        this.soLuongApDungToiDa = chiTietVoucher.getSoLuongApDungToiDa();
        this.voucher = voucherMapper.fromModelToDto(chiTietVoucher.getVoucher());
        this.sanPhamTangKem = sanPhamMapper.fromModelToDto(chiTietVoucher.getSanPhamTangKem());
    }
}
