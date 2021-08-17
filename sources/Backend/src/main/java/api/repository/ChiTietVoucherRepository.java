package api.repository;

import api.domain.ChiTietVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietVoucherRepository extends JpaRepository<ChiTietVoucher, ChiTietVoucher.ChiTietVoucherID> {
}
