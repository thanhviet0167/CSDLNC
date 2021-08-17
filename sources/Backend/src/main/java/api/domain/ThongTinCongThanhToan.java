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
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ThongTinCongThanhToan")
@Getter
@Setter
@NoArgsConstructor
public class ThongTinCongThanhToan implements Serializable {

    @Id
    @NotNull
    @Column(name = "MaCongThanhToan", length = 30, unique = true, nullable = false)
    private String maCongThanhToan;

    @NotNull
    @Column(name = "TenCongThanhToan", length = 100)
    private String tenCongThanhToan;

    @OneToMany(mappedBy = "thongTinCongThanhToan", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "phuongThucThanhToanSet"
    }, allowSetters = true)
    private Set<ThongTinThanhToan> thongTinThanhToanSet = new HashSet<>();
}
