package api.repository;

import api.domain.PhuongThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhuongThucThanhToanRepository extends JpaRepository<PhuongThucThanhToan, PhuongThucThanhToan.PhuongThucThanhToanID> {
}
