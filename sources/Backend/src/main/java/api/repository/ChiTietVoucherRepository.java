package api.repository;

import api.domain.ChiTietVoucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietVoucherRepository extends JpaRepository<ChiTietVoucher, ChiTietVoucher.ChiTietVoucherID> {
}
