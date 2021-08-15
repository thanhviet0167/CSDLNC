package api.repository;

import api.domain.VoucherApDung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherApDungRepository extends JpaRepository<VoucherApDung, VoucherApDung.VoucherApDungID> {
}
