package api.repository;

import api.domain.SanPhamYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamYeuThichRepository extends JpaRepository<SanPhamYeuThich, SanPhamYeuThich.SanPhamYeuThichID> {
}
