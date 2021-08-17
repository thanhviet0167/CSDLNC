package api.repository;

import api.domain.NhaCungCap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
    Page<NhaCungCap> findAllByTenNhaCungCapContainsOrUsernameIs(String name, String id, Pageable pageable);
}
