package api.repository;

import api.domain.VoucherApDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherApDungRepository extends JpaRepository<VoucherApDung, VoucherApDung.VoucherApDungID> {
}
