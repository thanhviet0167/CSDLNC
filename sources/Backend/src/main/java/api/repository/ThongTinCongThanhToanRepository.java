package api.repository;

import api.domain.ThongTinCongThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThongTinCongThanhToanRepository extends JpaRepository<ThongTinCongThanhToan, String> {
    @Query(value = "{CALL ThongKe_PTTT(:fromMonth, :fromYear, :toMonth, :toYear)}", nativeQuery = true)
    List<Object[]> getPaymentMethodStatistics(@Param("fromMonth") int fromMonth, @Param("fromYear") int fromYear, @Param("toMonth") int toMonth, @Param("toYear") int toYear);
}
