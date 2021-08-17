package api.repository;

import api.domain.ThongTinCongThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongTinCongThanhToanRepository extends JpaRepository<ThongTinCongThanhToan, String> {
}
