package api.repository;

import api.domain.BoSuuTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoSuuTapRepository extends JpaRepository<BoSuuTap, BoSuuTap.BoSuuTapID> {
    List<BoSuuTap> findAllByBoSuuTapID_Username(String nhaCungCap);
    Optional<BoSuuTap> findByBoSuuTapID_UsernameAndBoSuuTapID_Stt(String nhaCungCap, Integer stt);
}
