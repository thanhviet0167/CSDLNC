package api.repository;

import api.domain.GioHang;
import api.domain.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {
    @Query(value = "SELECT GioHang.* FROM GioHang WHERE GioHang.KhachHang LIKE :khachHang AND GioHang.TrangThaiDatHang = :status", nativeQuery = true)
    List<GioHang> findAllByKhachHangAndTrangThaiDatHang(@Param("khachHang") String khachHang,@Param("status") Integer trangThaiDatHang);

    Optional<GioHang> findByMaGioHang(Long maGioHang);

    void deleteByMaGioHang(Long maGioHang);
}
