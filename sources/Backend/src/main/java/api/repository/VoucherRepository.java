package api.repository;

import api.domain.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    @Query(value = "SELECT Voucher.* from Voucher WHERE Voucher.NhaCungCap IS NULL AND (:product is null or Voucher.SanPhamApDung = :product) AND Voucher.NgayKetThuc >= '2020-04-09 15:46:11.230' "
            , nativeQuery = true)
    List<Voucher> findAllSystemVoucher(@Param("product") Long productId);

    @Query(value = "SELECT Voucher.* from Voucher " +
            "WHERE (:store is null or Voucher.NhaCungCap LIKE :store) AND (:product is null or Voucher.SanPhamApDung = :product) AND (:type is null or Voucher.LoaiVoucher = :type) AND Voucher.NgayKetThuc >= '2020-04-09 15:46:11.230' "
            , nativeQuery = true)
    List<Voucher> findByQuery(@Param("store") String store, @Param("product") Long productId, @Param("type") Integer type);
}
