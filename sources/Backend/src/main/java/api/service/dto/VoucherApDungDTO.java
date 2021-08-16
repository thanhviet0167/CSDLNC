package api.service.dto;

import api.domain.ChiTietQuaTang;
import api.domain.GioHang;
import api.domain.Voucher;
import api.domain.VoucherApDung;
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
public class VoucherApDungDTO {

    private GioHangDTO gioHang;

    private VoucherDTO voucher;

    private Set<ChiTietQuaTang> chiTietQuaTangSet = new HashSet<>();

    public VoucherApDungDTO (VoucherApDung voucherApDung, GioHangMapper gioHangMapper, VoucherMapper voucherMapper) {
        this.gioHang = gioHangMapper.fromModelToDto(voucherApDung.getGioHang());
        this.voucher = voucherMapper.fromModelToDto(voucherApDung.getVoucher());

        this.chiTietQuaTangSet.addAll(voucherApDung.getChiTietQuaTangSet());
    }
}
