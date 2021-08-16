package api.repository;

import api.domain.ChiTietGioHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang, ChiTietGioHang.ChiTietGioHangID> {
}
