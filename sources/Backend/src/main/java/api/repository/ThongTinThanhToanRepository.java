package api.repository;

import api.domain.ThongTinThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThongTinThanhToanRepository extends JpaRepository<ThongTinThanhToan, ThongTinThanhToan.ThongTinThanhToanID> {
}
