package api.repository;

import api.domain.BoSuuTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoSuuTapRepository extends JpaRepository<BoSuuTap, BoSuuTap.BoSuuTapID> {
}
