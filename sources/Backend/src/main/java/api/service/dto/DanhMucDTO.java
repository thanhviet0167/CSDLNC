package api.service.dto;

import api.domain.DanhMuc;
import api.domain.DanhMucSanPham;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class DanhMucDTO {

    private Long maDanhMuc;
    private String tenDanhMuc;
    private Set<DanhMucSanPham> danhMucSanPhamSet = new HashSet<>();

    public DanhMucDTO(DanhMuc danhMuc) {
        this.maDanhMuc = danhMuc.getMaDanhMuc();
        this.tenDanhMuc = danhMuc.getTenDanhMuc();
        this.danhMucSanPhamSet.addAll(danhMuc.getDanhMucSanPhamSet());
    }
}
