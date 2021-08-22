package api.repository;

import api.domain.NhaCungCap;
import api.web.rest.vm.RevenueStatisticsVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
    Page<NhaCungCap> findAllByTenNhaCungCapContainsOrUsernameIs(String name, String id, Pageable pageable);

    @Query(value = "{CALL ThongKe_DoanhThu(:store, :fromMonth, :fromYear, :toMonth, :toYear)}", nativeQuery = true)
    List<Object[]> getRevenueStatistics(@Param("store") String store, @Param("fromMonth") int fromMonth, @Param("fromYear") int fromYear, @Param("toMonth") int toMonth, @Param("toYear") int toYear);

    @Query(value = "{CALL ThongKe_LuotMua(:store)}", nativeQuery = true)
    List<Object[]> getProductSubscriptionStatistics(@Param("store") String store);

    @Query(value = "{CALL ThongKe_LuotYeuThich(:store)}", nativeQuery = true)
    List<Object[]> getProductSaleStatistics(@Param("store") String store);

    @Query(value = "{CALL ThongKe_CuaHang_DanhGia(:fromMonth, :fromYear, :toMonth, :toYear)}", nativeQuery = true)
    List<Object[]> getStoreRateStatistics(@Param("fromMonth") int fromMonth, @Param("fromYear") int fromYear, @Param("toMonth") int toMonth, @Param("toYear") int toYear);

    @Query(value = "{CALL ThongKe_CuaHang_KhieuNai(:fromMonth, :fromYear, :toMonth, :toYear)}", nativeQuery = true)
    List<Object[]> getStoreComplainStatistics(@Param("fromMonth") int fromMonth, @Param("fromYear") int fromYear, @Param("toMonth") int toMonth, @Param("toYear") int toYear);
}
