package api.repository;

import api.domain.TinhThanhPho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhThanhPhoRepository extends JpaRepository<TinhThanhPho, Long> {
}
