package api.service.dto;

import api.domain.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class KhachHangDTO {

    private String username;
    private String password;
    private String hoTenKhachHang;
    private String email;
    private Integer gioiTinh;
    private Instant ngaySinh;
    private String anhDaiDien;
    private String sdtDangKy;

    private Set<SoDiaChi> soDiaChiSet = new HashSet<>();
    private Set<PhuongThucThanhToan> phuongThucThanhToanSet = new HashSet<>();
    private Set<SanPhamYeuThich> sanPhamYeuThichSet = new HashSet<>();
    private Set<TheoDoiNhaCungCap> theoDoiNhaCungCapSet = new HashSet<>();
    private Set<XemSanPham> xemSanPhamSet = new HashSet<>();
    private Set<GioHang> gioHangSet = new HashSet<>();

    public KhachHangDTO(KhachHang khachHang) {
        this.username = khachHang.getUsername();
        this.password = khachHang.getPassword();
        this.hoTenKhachHang = khachHang.getHoTenKhachHang();
        this.email = khachHang.getEmail();
        this.gioiTinh = khachHang.getGioiTinh();
        this.email = khachHang.getEmail();
        this.ngaySinh = khachHang.getNgaySinh();
        this.anhDaiDien = khachHang.getAnhDaiDien();
        this.sdtDangKy = khachHang.getSdtDangKy();

        this.soDiaChiSet.addAll(khachHang.getSoDiaChiSet());
        this.phuongThucThanhToanSet.addAll(khachHang.getPhuongThucThanhToanSet());
        this.sanPhamYeuThichSet.addAll(khachHang.getSanPhamYeuThichSet());
        this.theoDoiNhaCungCapSet.addAll(khachHang.getTheoDoiNhaCungCapSet());
        this.xemSanPhamSet.addAll(khachHang.getXemSanPhamSet());
        this.gioHangSet.addAll(khachHang.getGioHangSet());
    }

}

