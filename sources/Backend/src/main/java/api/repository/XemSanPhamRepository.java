package api.repository;

import api.domain.XemSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XemSanPhamRepository extends JpaRepository<XemSanPham, XemSanPham.XemSanPhamID> {
}
