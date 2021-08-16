package api.repository;

import api.domain.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
}
