package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "SoDiaChi")
@Getter
@Setter
@NoArgsConstructor
public class SoDiaChi implements Serializable {

    @EmbeddedId
    @NotNull
    private SoDiaChiID soDiaChiID;

    @NotNull
    @Column(name="HoTenNguoiNhan", length=50, nullable = false)
    private String hoTenNguoiNhan;

    @NotNull
    @Column(name="DiaChi", length=100, nullable = false)
    private String diaChi;

    @NotNull
    @Column(name="MaTinhThanhPho", nullable = false)
    private Integer maTinhThanhPho; // FK

    @NotNull
    @Column(name="SDT", length=11, nullable = false)
    private String sdt;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class SoDiaChiID implements Serializable {
        @NotNull
        @Column(name="Username", length=20, nullable = false)
        private String username; // FK

        @NotNull
        @Column(name="STT", nullable = false)
        private Integer stt;
    }

}
