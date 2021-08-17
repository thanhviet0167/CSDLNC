package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TinhThanhPho")
@Getter
@Setter
@NoArgsConstructor
public class TinhThanhPho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MaTinhThanhPho", unique = true, nullable = false)
    private Integer maTinhThanhPho;

    @NotNull
    @Column(name = "TenTinhThanhPho", length = 100, nullable = false)
    private String tenTinhThanhPho;

    @OneToMany(mappedBy = "tinhThanhPho", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "tinhThanhPho",
            "boSuuTapSet", "sanPhamSet",
            "theoDoiNhaCungCapSet", "voucherSet",
            "gioHangSet"
    })
    private Set<NhaCungCap> nhaCungCapSet = new HashSet<>();

    @OneToMany(mappedBy = "tinhThanhPho", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "tinhThanhPho",
            "gioHangSet"
    })
    private Set<SoDiaChi> soDiaChiSet = new HashSet<>();
}
