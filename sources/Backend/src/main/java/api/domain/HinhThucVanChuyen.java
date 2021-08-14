package api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "HinhThucVanChuyen")
@Getter
@Setter
@NoArgsConstructor
public class HinhThucVanChuyen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MaHinhThucVanChuyen", unique = true, nullable = false)
    private Long maHinhThucVanChuyen;

    @NotNull
    @Column(name = "TenHinhThucVanChuyen", length = 50, nullable = false)
    private String tenHinhThucVanChuyen;
}
