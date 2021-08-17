package api.repository;

import api.domain.ThongTinVanChuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongTinVanChuyenRepository extends JpaRepository<ThongTinVanChuyen, ThongTinVanChuyen.ThongTinVanChuyenID> {
}
