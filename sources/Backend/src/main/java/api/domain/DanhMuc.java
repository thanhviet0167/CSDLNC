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

    @OneToMany(mappedBy = "danhMuc", fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties(value = {
            "danhMuc",
            "sanPhamSet"
    })
    private Set<DanhMucSanPham> danhMucSanPhamSet = new HashSet<>();

}
