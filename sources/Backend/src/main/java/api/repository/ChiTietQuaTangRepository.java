package api.repository;

import api.domain.ChiTietQuaTang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietQuaTangRepository extends JpaRepository<ChiTietQuaTang, ChiTietQuaTang.ChiTietQuaTangID> {
}
