package api.service.impl;

import api.repository.NhaCungCapRepository;
import api.service.NhaCungCapService;
import api.service.dto.NhaCungCapDTO;
import api.service.mapper.NhaCungCapMapper;
import api.web.rest.vm.ProductStatisticsVM;
import api.web.rest.vm.RevenueStatisticsVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

    private final NhaCungCapRepository nhaCungCapRepository;

    private final NhaCungCapMapper nhaCungCapMapper;

    public NhaCungCapServiceImpl(NhaCungCapRepository nhaCungCapRepository, NhaCungCapMapper nhaCungCapMapper) {
        this.nhaCungCapRepository = nhaCungCapRepository;
        this.nhaCungCapMapper = nhaCungCapMapper;
    }

    @Override
    public Optional<NhaCungCapDTO> findOne(String keyword) {
        return nhaCungCapRepository.findById(keyword).map(nhaCungCapMapper::fromModelToDto);
    }

    @Override
    public Page<NhaCungCapDTO> findByKeyword(String keyword, Pageable pageable) {
        return nhaCungCapRepository.findAllByTenNhaCungCapContainsOrUsernameIs(keyword, keyword, pageable).map(nhaCungCapMapper::fromModelToDto);
    }

    @Override
    public RevenueStatisticsVM getRevenueStatistics(String store, String from, String to) {
        String[] froms = from.split("/");
        String[] tos = to.split("/");

        int fromMonth = Integer.parseInt(froms[0]);
        int fromYear = Integer.parseInt(froms[1]);

        int toMonth = Integer.parseInt(tos[0]);
        int toYear = Integer.parseInt(tos[1]);

        List<Object[]> resultList = nhaCungCapRepository.getRevenueStatistics(store, fromMonth, fromYear, toMonth, toYear);

        RevenueStatisticsVM revenueStatisticsVM = new RevenueStatisticsVM();
        revenueStatisticsVM.setNhaCungCap(store);

        List<RevenueStatisticsVM.RevenueStatisticItem> revenueStatisticItems = new ArrayList<>();

        resultList.forEach(result -> {
            String time = result[1] + "/" + result[0];
            long revenue = ((BigInteger) result[2]).longValue();
            int count = (int) result[3];

            RevenueStatisticsVM.RevenueStatisticItem item = new RevenueStatisticsVM.RevenueStatisticItem(time, revenue, count);
            revenueStatisticItems.add(item);
        });

        revenueStatisticsVM.setThongKe(revenueStatisticItems);

        return revenueStatisticsVM;
    }

    @Override
    public ProductStatisticsVM getProductSubscriptionStatistics(String store) {
        ProductStatisticsVM productStatisticsVM = new ProductStatisticsVM();
        List<ProductStatisticsVM.ProductStatisticItem> productStatisticItems = new ArrayList<>();

        List<Object[]> resultList = nhaCungCapRepository.getProductSubscriptionStatistics(store);

        resultList.forEach(result -> {
            Long productId = ((BigInteger) result[0]).longValue();
            String productName = (String) result[1];
            int count = (int) result[3];

            ProductStatisticsVM.ProductStatisticItem item = new ProductStatisticsVM.ProductStatisticItem(productId, productName, count);
            productStatisticItems.add(item);
        });

        productStatisticsVM.setLoai("YeuThich");
        productStatisticsVM.setSanPham(productStatisticItems);

        return productStatisticsVM;
    }

    @Override
    public ProductStatisticsVM getProductSaleStatistics(String store) {
        ProductStatisticsVM productStatisticsVM = new ProductStatisticsVM();
        List<ProductStatisticsVM.ProductStatisticItem> productStatisticItems = new ArrayList<>();

        List<Object[]> resultList = nhaCungCapRepository.getProductSaleStatistics(store);

        resultList.forEach(result -> {
            Long productId = ((BigInteger) result[0]).longValue();
            String productName = (String) result[1];
            int count = (int) result[3];

            ProductStatisticsVM.ProductStatisticItem item = new ProductStatisticsVM.ProductStatisticItem(productId, productName, count);
            productStatisticItems.add(item);
        });

        productStatisticsVM.setLoai("BanRa");
        productStatisticsVM.setSanPham(productStatisticItems);

        return productStatisticsVM;
    }
}
