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
import java.time.Instant;

@Entity
@Table(name = "TinhThanhPho")
@Getter
@Setter
@NoArgsConstructor
public class TinhThanhPho implements Serializable {

    @Id
    @NotNull
    @Column(name = "MaTinhThanhPho", unique = true, nullable = false)
    private Integer maTinhThanhPho;

    @NotNull
    @Column(name = "TenTinhThanhPho", length = 100, nullable = false)
    private String tenTinhThanhPho;
}
