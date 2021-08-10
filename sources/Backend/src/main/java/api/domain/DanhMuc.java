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
@Table(name = "DanhMuc")
@Getter
@Setter
@NoArgsConstructor
public class DanhMuc implements Serializable {

    @Id
    @NotNull
    @Column(name = "MaDanhMuc", unique = true, nullable = false)
    private Long maDanhMuc;

    @NotNull
    @Column(name = "TenDanhMuc", length = 50, nullable = false)
    private String tenDanhMuc;

    @Column(name = "MoTa", columnDefinition="TEXT")
    private String moTa;

}
