package api.service;

import api.domain.Voucher;

import java.util.List;
import java.util.Optional;

public interface VoucherService {
    List<Voucher> findByCondition(Long productId, String store, Integer type);

    Optional<Voucher> findOne(Long id);
}
