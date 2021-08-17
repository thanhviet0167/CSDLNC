package api.repository;

import api.domain.TheoDoiNhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheoDoiNhaCungCapRepository extends JpaRepository<TheoDoiNhaCungCap, TheoDoiNhaCungCap.TheoDoiNhaCungCapID> {
}
