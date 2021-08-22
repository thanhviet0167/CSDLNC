package api.repository;

import api.domain.HinhThucVanChuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HinhThucVanChuyenRepository extends JpaRepository<HinhThucVanChuyen, Long> {
    @Query(value = "{CALL ThongKe_PTVC(:fromMonth, :fromYear, :toMonth, :toYear)}", nativeQuery = true)
    List<Object[]> getTransportMethodStatistics(@Param("fromMonth") int fromMonth,@Param("fromYear") int fromYear,@Param("toMonth") int toMonth,@Param("toYear") int toYear);
}
