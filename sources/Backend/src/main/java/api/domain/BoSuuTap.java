package api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "BoSuuTap")
@Getter
@Setter
@NoArgsConstructor
public class BoSuuTap implements Serializable {

    @EmbeddedId
    @NotNull
    private BoSuuTapID boSuuTapID;

    @NotNull
    @Column(name="TenBoSuuTap", length=100, nullable = false)
    private String tenBoSuuTap;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public class BoSuuTapID implements Serializable {
        @NotNull
        @Column(name="Username", length=20, nullable = false)
        private String username; // FK

        @NotNull
        @Column(name="STT", nullable = false)
        private Integer stt;
    }

}
