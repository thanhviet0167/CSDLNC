package api.repository;

import api.domain.SanPhamYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamYeuThichRepository extends JpaRepository<SanPhamYeuThich, SanPhamYeuThich.SanPhamYeuThichID> {
}
