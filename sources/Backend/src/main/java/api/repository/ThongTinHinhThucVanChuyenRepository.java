package api.repository;

import api.domain.ThongTinHinhThucVanChuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongTinHinhThucVanChuyenRepository extends JpaRepository<ThongTinHinhThucVanChuyen, ThongTinHinhThucVanChuyen.ThongTinHinhThucVanChuyenID> {
}
