package api.service.impl;

import api.domain.SanPham;
import api.repository.SanPhamRepository;
import api.service.SanPhamService;
import api.service.dto.SanPhamDTO;
import api.service.mapper.SanPhamMapper;
import api.web.rest.vm.ObjectPaginationVM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    private final SanPhamRepository sanPhamRepository;
    private final SanPhamMapper sanPhamMapper;

    public SanPhamServiceImpl(SanPhamRepository sanPhamRepository, SanPhamMapper sanPhamMapper) {
        this.sanPhamRepository = sanPhamRepository;
        this.sanPhamMapper = sanPhamMapper;
    }

    @Override
    public ObjectPaginationVM searchWithCondition(Map<String, String> queryParams, Integer page, Integer pageSize, String sort) {
        String productName = null;
        Long category = null; Long productCategory= null;
        String store = null; Integer collection = null;
        Long fromPrice = null; Long toPrice = null;
        Integer fromRate = null; Integer toRate = null;
        Float fromDiscount = null; Float toDiscount = null;

        if (queryParams.containsKey("productName")) productName = queryParams.get("productName");
        if (queryParams.containsKey("category")) category = Long.parseLong(queryParams.getOrDefault("category", "1"));
        if (queryParams.containsKey("categoryProduct")) productCategory = Long.parseLong(queryParams.getOrDefault("categoryProduct", "1"));
        if (queryParams.containsKey("store")) store = queryParams.get("store");
        if (queryParams.containsKey("collection")) collection = Integer.parseInt(queryParams.getOrDefault("collection", "1"));
        if (queryParams.containsKey("fromPrice"))  fromPrice = Long.parseLong(queryParams.getOrDefault("fromPrice", "1"));
        if (queryParams.containsKey("toPrice")) toPrice = Long.parseLong(queryParams.getOrDefault("toPrice", "1"));
        if (queryParams.containsKey("fromRate")) fromRate = Integer.parseInt(queryParams.getOrDefault("fromRate", "1"));
        if (queryParams.containsKey("toRate")) toRate = Integer.parseInt(queryParams.getOrDefault("toRate", "1"));
        if (queryParams.containsKey("fromDiscount")) fromDiscount = Float.parseFloat(queryParams.getOrDefault("fromDiscount", "0.0"));
        if (queryParams.containsKey("toDiscount")) toDiscount = Float.parseFloat(queryParams.getOrDefault("toDiscount", "1.0"));

        if (fromDiscount == null && toDiscount != null) {
            fromDiscount = 0.0F;
        }

        if (fromDiscount != null && toDiscount == null) {
            toDiscount = 1.0F;
        }

        String formatSort = "product_price,asc";

        if (StringUtils.isNoneBlank(sort)) {
            formatSort = sort.toLowerCase();
        }

        Integer offset = page * pageSize;
        List<Object[]> result;
        Integer totalCount;
        Integer totalPage;
        if (fromDiscount != null) {
            totalCount = sanPhamRepository.countWithRateAndDiscount(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, fromDiscount, toDiscount);
        } else {
            totalCount = sanPhamRepository.countWithRate(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate);
        }

        if (fromDiscount != null) {
            switch (formatSort) {
                case "product_rate,desc":
                    result = sanPhamRepository.findWithRateAndDiscountAndOrderByRateDESC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, fromDiscount, toDiscount, offset, pageSize);
                    break;
                case "product_rate,asc":
                    result = sanPhamRepository.findWithRateAndDiscountAndOrderByRateASC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, fromDiscount, toDiscount, offset, pageSize);
                    break;
                case "product_price,desc":
                    result = sanPhamRepository.findWithRateAndDiscountAndOrderByPriceDESC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, fromDiscount, toDiscount, offset, pageSize);
                    break;
//            case "product_price,asc":
//                result = sanPhamRepository.findWithRateAndDiscountAndOrderByPriceASC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, fromDiscount, toDiscount, offset, pageSize);
//                break;
                case "voucher_discount,desc":
                    result = sanPhamRepository.findWithRateAndDiscountAndOrderByDiscountDESC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, fromDiscount, toDiscount, offset, pageSize);
                    break;
                case "voucher_discount,asc":
                    result = sanPhamRepository.findWithRateAndDiscountAndOrderByDiscountASC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, fromDiscount, toDiscount, offset, pageSize);
                    break;
                default:
                    // product_price,asc
                    result = sanPhamRepository.findWithRateAndDiscountAndOrderByPriceASC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, fromDiscount, toDiscount, offset, pageSize);
            }
        } else {
            switch (formatSort) {
                case "product_rate,desc":
                    result = sanPhamRepository.findWithRateAndOrderByRateDESC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, offset, pageSize);
                    break;
                case "product_rate,asc":
                    result = sanPhamRepository.findWithRateAndOrderByRateASC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, offset, pageSize);
                    break;
                case "product_price,desc":
                    result = sanPhamRepository.findWithRateAndOrderByPriceDESC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, offset, pageSize);
                    break;
                default:
                    // product_price,asc
                    result = sanPhamRepository.findWithRateAndOrderByPriceASC(productName, store, collection, category, productCategory, fromPrice, toPrice, fromRate, toRate, offset, pageSize);
            }
        }

        List<Long> ids = new ArrayList<>();
        List<Integer> rates = new ArrayList<>();

        for (Object[] objects : result) {
            if (!ids.contains(((BigInteger) objects[0]).longValue())) {
                ids.add(((BigInteger) objects[0]).longValue());
                rates.add((int) objects[1]);
            }
        }

        List<SanPham> sanPhamList = sanPhamRepository.findByIds(ids);
        List<Long> sanPhamIdList = sanPhamList.stream().map(SanPham::getMaSanPham).collect(Collectors.toList());

        List<SanPham> finalList = new ArrayList<>();
        int pos = 0;

        for (Long id : ids) {
            int index = sanPhamIdList.indexOf(id);

//            SanPhamDTO sanPhamDTO = sanPhamMapper.fromModelToDto();
            SanPham sanPham = sanPhamList.get(index);
            sanPham.setRate(rates.get(pos));
            finalList.add(sanPham);

            pos++;
        }

        totalPage = totalCount / pageSize;

        if (totalPage * pageSize != totalCount) {
            totalPage = totalPage + 1;
        }

        return new ObjectPaginationVM(finalList, page, pageSize, totalCount, totalPage);
    }

    @Override
    public Page<SanPham> searchAll(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public Optional<SanPham> get(Long id) {
        return sanPhamRepository.findById(id);
    }
}
