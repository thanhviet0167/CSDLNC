package api.repository;

import api.domain.KhieuNaiDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhieuNaiDonHangRepository extends JpaRepository<KhieuNaiDonHang, KhieuNaiDonHang.KhieuNaiDonHangID> {
}
