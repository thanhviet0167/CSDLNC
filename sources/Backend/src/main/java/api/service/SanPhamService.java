package api.service;

import api.domain.SanPham;
import api.web.rest.vm.ObjectPaginationVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SanPhamService {

    Page<SanPham> searchAll(Pageable pageable);

    ObjectPaginationVM searchWithCondition(Map<String, String> queryParams, Integer page, Integer pageSize, String sort);

    Optional<SanPham> get(Long id);
}
