package api.service.dto;

import api.domain.DanhMucSanPham;
import api.domain.SanPham;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DanhMucSanPhamDTO {

    private Long maDanhMucSanPham;
    private String tenDanhMucSanPham;
    private String moTa;

    private DanhMucDTO danhMuc;

    private Set<SanPham> sanPhamSet = new HashSet<>();

    public DanhMucSanPhamDTO(DanhMucSanPham danhMucSanPham, DanhMucMapper danhMucMapper) {
        this.maDanhMucSanPham = danhMucSanPham.getMaDanhMucSanPham();
        this.tenDanhMucSanPham = danhMucSanPham.getTenDanhMucSanPham();
        this.moTa = danhMucSanPham.getMoTa();
        this.sanPhamSet.addAll(danhMucSanPham.getSanPhamSet());

        this.danhMuc = danhMucMapper.fromModelToDto(danhMucSanPham.getDanhMuc());

    }

}
