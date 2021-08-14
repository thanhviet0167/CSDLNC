package api.repository;

import api.domain.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String>, KhachHangRepositoryCustom {
    Optional<KhachHang> findByUsername(String username); //Select * From KhachHang Where Username = username


}
