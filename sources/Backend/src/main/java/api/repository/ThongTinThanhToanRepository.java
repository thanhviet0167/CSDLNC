package api.repository;

import api.domain.ThongTinThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongTinThanhToanRepository extends JpaRepository<ThongTinThanhToan, ThongTinThanhToan.ThongTinThanhToanID> {
}
