package api.repository;

import api.domain.SoDiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoDiaChiRepository extends JpaRepository<SoDiaChi, SoDiaChi.SoDiaChiID> {
    @Query(value = "SELECT SoDiaChi.* FROM SoDiaChi WHERE SoDiaChi.Username LIKE :khachHang", nativeQuery = true)
    List<SoDiaChi> findAllByKhachHang(@Param("khachHang") String khachHang);

}
