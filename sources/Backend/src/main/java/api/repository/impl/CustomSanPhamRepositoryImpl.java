package api.repository.impl;

import api.domain.SanPham;
import api.repository.CustomSanPhamRepostiory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomSanPhamRepositoryImpl implements CustomSanPhamRepostiory {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<SanPham> findByFilter(String productName, Long category, Long productCategory, String store, Integer collection, Long fromPrice, Long toPrice, Integer fromRate, Integer toRate, Integer fromDiscount, Integer toDiscount, Pageable pageable) {
        StringBuilder queryBuilder = new StringBuilder();

        StringBuilder selectClauseBuilder = new StringBuilder();
        StringBuilder fromClauseBuilder = new StringBuilder();
        StringBuilder whereClauseBuilder = new StringBuilder();
        StringBuilder groupClauseBuild = new StringBuilder();
        StringBuilder havingClauseBuild = new StringBuilder();
        StringBuilder orderByClauseBuild = new StringBuilder();

        selectClauseBuilder.append("SELECT SanPham.* ");
        fromClauseBuilder.append("FROM SanPham S ");
        whereClauseBuilder.append("WHERE ");

        // su dung rate
        selectClauseBuilder.append(",AVG(c.DanhGia) AS Rate ");
        fromClauseBuilder.append("JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham ");

        if (StringUtils.isNoneBlank(productName)) {
            queryBuilder.append("S.TenSanPham LIKE %" + productName + "% ");
        }

        if (productCategory != -1) {
            fromClauseBuilder.append("JOIN DanhMucSanPham CP ON S.DanhMucSanPham = CP.MaDanhMucSanPham ");
            fromClauseBuilder.append("JOIN DanhMuc C ON C.MaDanhMuc = CP.DanhMuc ");
        }

        if (fromDiscount != -1 || toDiscount != -1) {
            fromClauseBuilder.append("JOIN Voucher V ON S.MaSanPham = V.SanPhamApDung ");
        }

        return null;
    }
}
