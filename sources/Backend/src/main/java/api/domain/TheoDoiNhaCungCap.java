package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "TheoDoiNhaCungCap")
@Getter
@Setter
@NoArgsConstructor
public class TheoDoiNhaCungCap implements Serializable {

    @EmbeddedId
    @NotNull
    private TheoDoiNhaCungCapID theoDoiNhaCungCapID;

    @NotNull
    @Column(name="NgayTheoDoi", nullable = false)
    private Instant ngayTheoDoi;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class TheoDoiNhaCungCapID implements Serializable {
        @NotNull
        @Column(name="MaKhachHang", length=20, nullable = false)
        private String maKhachHang; // FK

        @NotNull
        @Column(name="MaNhaCungCap", length=20, nullable = false)
        private String maNhaCungCap; // FK
    }

}
