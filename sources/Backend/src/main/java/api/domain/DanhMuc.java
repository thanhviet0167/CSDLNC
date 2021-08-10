package api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "DanhMuc")
@Getter
@Setter
@NoArgsConstructor
public class DanhMuc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "MaDanhMuc", unique = true, nullable = false)
    private Long maDanhMuc;

    @NotNull
    @Column(name = "TenDanhMuc", length = 50, nullable = false)
    private String tenDanhMuc;

    @Column(name = "MoTa", columnDefinition="TEXT")
    private String moTa;

}
