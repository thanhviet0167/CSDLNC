package api.repository;

import api.domain.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Long> {

    @Query(value = "SELECT DonHang.* FROM DonHang JOIN GioHang ON DonHang.GioHang = GioHang.MaGioHang WHERE GioHang.KhachHang LIKE :customer AND (:status is null or DonHang.TrangThaiThanhToan = :status)"
            , nativeQuery = true)
    List<DonHang> findAllByKhachHang(@Param("customer") String khachHang, @Param("status") Integer status);

    @Query(value = "SELECT DonHang.* FROM DonHang WHERE DonHang.MaGiaoDich = :transaction"
            , nativeQuery = true)
    List<DonHang> findAllByGiaoDich(@Param("transaction") Long giaoDich);

    @Query(value = "SELECT DonHang.* FROM DonHang WHERE DonHang.GioHang = :cart", nativeQuery = true)
    DonHang findByGioHang(@Param("cart") Long gioHang);

    @Modifying
    @Query(value = "{CALL update_HangTon(:MaGioHang)}", nativeQuery = true)
    void capNhatHangTon(@Param("MaGioHang") Long gioHang);

    @Query(value = "{CALL ThongKe_TyLeDonHangThanhCong(:year)}", nativeQuery = true)
    List<Object[]> getSuccessOrderStatistics(@Param("year") Integer year);
}