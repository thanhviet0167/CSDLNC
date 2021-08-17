package api.repository;

import api.domain.DanhMucSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucSanPhamRepository extends JpaRepository<DanhMucSanPham, Long> {
}
