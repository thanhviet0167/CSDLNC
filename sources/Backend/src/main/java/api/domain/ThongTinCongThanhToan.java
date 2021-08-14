package api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
}
