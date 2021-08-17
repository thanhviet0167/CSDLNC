package api.repository;

import api.domain.HinhThucVanChuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhThucVanChuyenRepository extends JpaRepository<HinhThucVanChuyen, Long> {
}
