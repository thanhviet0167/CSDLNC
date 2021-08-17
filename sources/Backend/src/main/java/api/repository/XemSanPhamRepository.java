package api.repository;

import api.domain.XemSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XemSanPhamRepository extends JpaRepository<XemSanPham, XemSanPham.XemSanPhamID> {
}
