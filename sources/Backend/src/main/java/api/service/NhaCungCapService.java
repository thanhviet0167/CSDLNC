package api.service;

import api.service.dto.NhaCungCapDTO;
import api.web.rest.vm.RevenueStatisticsVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NhaCungCapService {
    Page<NhaCungCapDTO> findByKeyword(String keyword, Pageable pageable);
    Optional<NhaCungCapDTO> findOne(String id);
    RevenueStatisticsVM getRevenueStatistics(String store, String from, String to);
}
