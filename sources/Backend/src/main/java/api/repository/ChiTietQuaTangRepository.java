package api.repository;

import api.domain.ChiTietQuaTang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietQuaTangRepository extends JpaRepository<ChiTietQuaTang, ChiTietQuaTang.ChiTietQuaTangID> {
}
