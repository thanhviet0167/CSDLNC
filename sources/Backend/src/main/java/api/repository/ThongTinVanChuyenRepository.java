package api.repository;

import api.domain.ThongTinVanChuyen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThongTinVanChuyenRepository extends JpaRepository<ThongTinVanChuyen, ThongTinVanChuyen.ThongTinVanChuyenID> {
}
