package api.repository.impl;

import api.domain.SanPham;
import api.repository.SanPhamRepositoryCustom;
import api.web.rest.vm.ObjectPaginationVM;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
public class SanPhamRepositoryCustomImpl implements SanPhamRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

//    public SanPhamRepositoryCustomImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public ObjectPaginationVM findByFilter(
            String productName,
            Long category, Long productCategory,
            String store, Integer collection,
            Long fromPrice, Long toPrice,
            Integer fromRate, Integer toRate,
            Integer fromDiscount, Integer toDiscount,
            Integer pageNumber, Integer pageSize, String sort
    ) {
        String nativeQuery;
        String countNativeQuery;

        StringBuilder selectClauseBuilder = new StringBuilder();
        StringBuilder fromClauseBuilder = new StringBuilder();
        StringBuilder whereClauseBuilder = new StringBuilder();
        StringBuilder groupClauseBuilder = new StringBuilder();
        StringBuilder havingClauseBuilder = new StringBuilder();
        StringBuilder orderByClauseBuilder = new StringBuilder();

        selectClauseBuilder.append("SELECT SanPham ");
        fromClauseBuilder.append("FROM SanPham ");
        whereClauseBuilder.append("WHERE ");

        // su dung rate
        fromClauseBuilder.append("JOIN ChiTietGioHang ON SanPham.MaSanPham = ChiTietGioHang.MaSanPham ");
        groupClauseBuilder.append("GROUP BY SanPham.MaSanPham ");

        if (StringUtils.isNoneBlank(productName)) {
            whereClauseBuilder.append("SanPham.TenSanPham LIKE '%").append(productName).append("%' ");
        }

        if (category != -1) {
            whereClauseBuilder.append("AND SanPham.DanhMucSanPham = ").append(category).append(" ");
        }

        if (productCategory != -1) {
            fromClauseBuilder.append("JOIN DanhMucSanPham ON SanPham.DanhMucSanPham = DanhMucSanPham.MaDanhMucSanPham ");
            fromClauseBuilder.append("JOIN DanhMuc ON DanhMuc.MaDanhMuc = DanhMucSanPham.DanhMuc ");

            whereClauseBuilder.append("AND DanhMuc.MaDanhMuc = ").append(productCategory).append(" ");
        }

        if (StringUtils.isNoneBlank(store)) {
            whereClauseBuilder.append("AND SanPham.NhaCungCap LIKE '").append(store).append("' ");
        }

        if (collection != -1) {
            if (StringUtils.isBlank(store)) {
                whereClauseBuilder.append("AND SanPham.NhaCungCap LIKE '").append(store).append("' ");
            }

            whereClauseBuilder.append("AND SanPham.STT_BoSuuTap = ").append(collection).append(" ");
        }

        if (fromPrice != -1) {
            whereClauseBuilder.append("AND SanPham.GiaHienHanh >= ").append(fromPrice).append(" ");
        }

        if (toPrice != -1) {
            whereClauseBuilder.append("AND SanPham.GiaHienHanh <= ").append(fromPrice).append(" ");
        }

        if (fromRate != -1 || toRate != -1) {
            havingClauseBuilder.append("HAVING ");

            if (fromRate != -1) {
             havingClauseBuilder.append("AVG(ChiTietGioHang.DanhGia) >= ").append(fromRate).append(" ");
            }

            if (toRate != -1) {
                havingClauseBuilder.append("AND AVG(ChiTietGioHang.DanhGia) <= ").append(toRate).append(" ");
            }
        }

        if (fromDiscount != -1 || toDiscount != -1) {
            fromClauseBuilder.append("JOIN Voucher ON SanPham.MaSanPham = Voucher.SanPhamApDung ");

            if (fromDiscount != -1) {
                whereClauseBuilder.append("AND Voucher.PhanTramKhuyenMai >= ").append(fromDiscount).append(" ");
            }

            if (toDiscount != -1) {
                whereClauseBuilder.append("AND Voucher.PhanTramKhuyenMai <= ").append(toDiscount).append(" ");
            }
        }

        if (StringUtils.isNoneBlank(sort)) {
            String[] param = sort.split(",");
            String field;
            String order = param[1].equalsIgnoreCase("DESC") ? "DESC" : "ASC";

            switch (param[0]) {
                case "product_rate":
                    field = "AVG(ChiTietGioHang.DanhGia) ";
                    break;
                case "voucher_discount":
                    field = "Voucher.PhanTramKhuyenMai ";
                    break;
                default:
                    // product_price
                    field = "SanPham.GiaHienHanh ";
            }

            orderByClauseBuilder.append("ORDER BY ").append(field).append(order);
        } else {
            orderByClauseBuilder.append("ORDER BY GiaHienHanh ASC");
        }

        nativeQuery = selectClauseBuilder.toString() + fromClauseBuilder + whereClauseBuilder + groupClauseBuilder + havingClauseBuilder + orderByClauseBuilder;
        countNativeQuery = "SELECT COUNT(SanPham.MaSanPham) " + fromClauseBuilder + whereClauseBuilder + groupClauseBuilder + havingClauseBuilder + orderByClauseBuilder;

        nativeQuery = "SELECT SanPham FROM SanPham";
        countNativeQuery = "SELECT COUNT(SanPham) FROM SanPham";

        System.out.println("search with query: " + nativeQuery);

        nativeQuery = nativeQuery.replace("WHERE AND", "WHERE");
        nativeQuery = nativeQuery.replace("HAVING AND ", "HAVING");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();

        Query query = em.createQuery(nativeQuery, SanPham.class);
        query.setFirstResult((pageNumber) * pageSize);
        query.setMaxResults(pageSize);

        List<SanPham> sanPhamList = query.getResultList();

        Query queryTotal = entityManager.createQuery
                (countNativeQuery);

        int countResult = (int) queryTotal.getSingleResult();
        int totalPage = countResult / pageSize;
        return new ObjectPaginationVM(sanPhamList, pageNumber, pageSize, countResult, totalPage);
    }
}
