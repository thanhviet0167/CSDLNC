package api.repository;

import api.domain.DanhMucSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DanhMucSanPhamRepository extends JpaRepository<DanhMucSanPham, Long> {
}
