package api.repository;

import api.domain.PhuongThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhuongThucThanhToanRepository extends JpaRepository<PhuongThucThanhToan, PhuongThucThanhToan.PhuongThucThanhToanID> {
    PhuongThucThanhToan findByPhuongThucThanhToanID_UsernameAndPhuongThucThanhToanID_TaiKhoanThanhToanAndPhuongThucThanhToanID_CongThanhToan(String khachHang, String taiKhoan, String cong);
}
