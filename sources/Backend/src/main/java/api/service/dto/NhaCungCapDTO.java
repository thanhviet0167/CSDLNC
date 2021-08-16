package api.service.dto;

import api.domain.*;
import api.service.mapper.TinhThanhPhoMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class NhaCungCapDTO extends KhachHangDTO {

    private String tenNhaCungCap;
    private String moTa;
    private Instant ngayThamGia;
    private String sdtLienLac;
    private String diaChi;

    private TinhThanhPhoDTO tinhThanhPho;

    private Set<BoSuuTap> boSuuTapSet = new HashSet<>();
    private Set<SanPham> sanPhamSet = new HashSet<>();
    private Set<Voucher> voucherSet = new HashSet<>();
    private Set<GioHang> gioHangSet = new HashSet<>();

    public NhaCungCapDTO(NhaCungCap nhaCungCap, TinhThanhPhoMapper tinhThanhPhoMapper) {
        this.tenNhaCungCap = nhaCungCap.getTenNhaCungCap();
        this.moTa = nhaCungCap.getMoTa();
        this.ngayThamGia = nhaCungCap.getNgayThamGia();
        this.sdtLienLac = nhaCungCap.getSdtLienLac();
        this.diaChi = nhaCungCap.getDiaChi();

        this.tinhThanhPho = tinhThanhPhoMapper.fromModelToDto(nhaCungCap.getTinhThanhPho());

        this.boSuuTapSet.addAll(nhaCungCap.getBoSuuTapSet());
        this.sanPhamSet.addAll(nhaCungCap.getSanPhamSet());
        this.voucherSet.addAll(nhaCungCap.getVoucherSet());
        this.gioHangSet.addAll(nhaCungCap.getGioHangSet());
    }

}
