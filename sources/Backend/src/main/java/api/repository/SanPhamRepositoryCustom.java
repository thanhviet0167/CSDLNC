package api.repository;

import api.web.rest.vm.ObjectPaginationVM;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepositoryCustom {

    ObjectPaginationVM findByFilter(
            String productName,
            Long category, Long productCategory,
            String store, Integer collection,
            Long fromPrice, Long toPrice,
            Integer fromRate, Integer toRate,
            Integer fromDiscount, Integer toDiscount,
            Integer pageNumber, Integer pageSize, String sort
            );
}
