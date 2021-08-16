package api.repository;

import api.domain.KhieuNaiDonHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhieuNaiDonHangRepository extends JpaRepository<KhieuNaiDonHang, KhieuNaiDonHang.KhieuNaiDonHangID> {
}
