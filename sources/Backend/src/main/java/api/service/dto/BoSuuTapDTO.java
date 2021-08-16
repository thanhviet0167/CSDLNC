package api.service.dto;

import api.domain.NhaCungCap;
import api.domain.BoSuuTap;
import api.domain.SanPham;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BoSuuTapDTO {
    private String nhaCungCap;
    private Integer stt;
    private String tenBST;
    Set<SanPham> sanPhamSet = new HashSet<SanPham>();

    public BoSuuTapDTO(BoSuuTap bst) {
        this.nhaCungCap = bst.getBoSuuTapID().getUsername();
        this.stt = bst.getBoSuuTapID().getStt();
        this.tenBST = bst.getTenBoSuuTap();
        this.sanPhamSet.addAll(bst.getSanPhamSet());
    }
}
