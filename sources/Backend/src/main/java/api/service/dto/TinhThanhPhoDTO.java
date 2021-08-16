package api.service.dto;

import api.domain.NhaCungCap;
import api.domain.SoDiaChi;
import api.domain.TinhThanhPho;
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
public class TinhThanhPhoDTO {

    private Integer maTinhThanhPho;
    private String tenTinhThanhPho;

    private Set<NhaCungCap> nhaCungCapSet = new HashSet<>();
    private Set<SoDiaChi> soDiaChiSet = new HashSet<>();

    public TinhThanhPhoDTO(TinhThanhPho tinhThanhPho) {
        this.maTinhThanhPho = tinhThanhPho.getMaTinhThanhPho();
        this.tenTinhThanhPho = tinhThanhPho.getTenTinhThanhPho();

        this.nhaCungCapSet.addAll(tinhThanhPho.getNhaCungCapSet());
        this.soDiaChiSet.addAll(tinhThanhPho.getSoDiaChiSet());
    }

}
