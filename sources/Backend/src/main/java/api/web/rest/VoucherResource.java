package api.web.rest;

import api.domain.Voucher;
import api.service.VoucherService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VoucherResource {

    private VoucherService voucherService;

    public VoucherResource(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping("/voucher")
    public ResponseEntity<List<Voucher>> getVoucher(
            @RequestParam(required = false) Long productId,
            @RequestParam(required = false) String store,
            @RequestParam(required = false) Integer type
    ) {
        List<Voucher> voucherList = voucherService.findByCondition(productId, store, type);
        return ResponseEntity.ok(voucherList);
    }

    @GetMapping("/voucher/{id}")
    public ResponseEntity<Voucher> get(
            @PathVariable Long id
    ) {
        Optional<Voucher> voucherOptional = voucherService.findOne(id);

        if (!voucherOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(voucherOptional.get());
    }
}
