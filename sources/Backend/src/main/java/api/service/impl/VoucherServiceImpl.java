package api.service.impl;

import api.domain.Voucher;
import api.repository.VoucherRepository;
import api.service.VoucherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    public VoucherServiceImpl(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @Override
    public List<Voucher> findByCondition(Long productId, String store, Integer type) {
        if (type != null) {
            if (type == 3) {
                return voucherRepository.findAllSystemVoucher(productId);
            }
        }

        return voucherRepository.findByQuery(store, productId, type);
    }

    @Override
    public Optional<Voucher> findOne(Long id) {
        return voucherRepository.findById(id);
    }
}
