package api.repository;

import api.domain.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonHangRepository extends JpaRepository<DonHang, Long> {
}
