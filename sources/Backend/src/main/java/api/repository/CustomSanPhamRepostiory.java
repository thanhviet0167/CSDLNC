package api.repository;

import api.domain.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomSanPhamRepostiory {

    Page<SanPham> findByFilter(
            String productName,
            Long category, Long productCategory,
            String store, Integer collection,
            Long fromPrice, Long toPrice,
            Integer fromRate, Integer toRate,
            Integer fromDiscount, Integer toDiscount,
            Pageable pageable
            );
}
