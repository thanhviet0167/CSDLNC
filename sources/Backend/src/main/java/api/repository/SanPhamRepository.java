package api.repository;

import api.domain.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long>, SanPhamRepositoryCustom {
    @Query(value =
            "SELECT S.MaSanPham as MaSanPham, AVG(C.DanhGia) as Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "WHERE " +
                "(:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY AVG(C.DanhGia) DESC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndOrderByRateDESC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT S.MaSanPham as MaSanPham, AVG(C.DanhGia) as Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "WHERE " +
                "(:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY AVG(C.DanhGia) ASC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndOrderByRateASC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT S.MaSanPham as MaSanPham, AVG(C.DanhGia) as Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "WHERE " +
                "(:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham, S.GiaHienHanh \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY S.GiaHienHanh DESC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndOrderByPriceDESC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT S.MaSanPham as MaSanPham, AVG(C.DanhGia) as Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "WHERE " +
                "(:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham, S.GiaHienHanh \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY S.GiaHienHanh ASC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndOrderByPriceASC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT COUNT (*) FROM " +
                "(SELECT DISTINCT S.MaSanPham \n" +
                "FROM SanPham S \n" +
                "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
                "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
                "WHERE " +
                    "(:productName is null or S.TenSanPham LIKE :productName) " +
                    "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                    "AND (:store is null or S.NhaCungCap LIKE :store) " +
                    "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                    "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                    "AND (:category is null or DMSP.DanhMuc = :category) " +
                    "\n" +
                "GROUP BY S.MaSanPham \n" +
                "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate)) CLAIMS \n",
            nativeQuery = true)
    Integer countWithRate(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate
    );

    @Query(value =
            "SELECT S.MaSanPham, AVG(C.DanhGia) AS Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "LEFT JOIN Voucher V ON S.MaSanPham = V.SanPhamApDung \n" +
            "WHERE " +
                "(:fromDiscount is null or V.PhanTramKhuyenMai >= :fromDiscount) AND (:toDiscount is null or V.PhanTramKhuyenMai <= :toDiscount) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham, V.PhanTramKhuyenMai \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY AVG(C.DanhGia) DESC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndDiscountAndOrderByRateDESC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("fromDiscount") Float fromDiscount,@Param("toDiscount") Float toDiscount,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT S.MaSanPham, AVG(C.DanhGia) AS Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "LEFT JOIN Voucher V ON S.MaSanPham = V.SanPhamApDung \n" +
            "WHERE " +
                "(:fromDiscount is null or V.PhanTramKhuyenMai >= :fromDiscount) AND (:toDiscount is null or V.PhanTramKhuyenMai <= :toDiscount) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham, V.PhanTramKhuyenMai \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY AVG(C.DanhGia) ASC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndDiscountAndOrderByRateASC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("fromDiscount") Float fromDiscount,@Param("toDiscount") Float toDiscount,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT S.MaSanPham, AVG(C.DanhGia) AS Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "LEFT JOIN Voucher V ON S.MaSanPham = V.SanPhamApDung\n" +
            "WHERE " +
                "(:fromDiscount is null or V.PhanTramKhuyenMai >= :fromDiscount) AND (:toDiscount is null or V.PhanTramKhuyenMai <= :toDiscount) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham, V.PhanTramKhuyenMai \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY V.PhanTramKhuyenMai DESC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndDiscountAndOrderByDiscountDESC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("fromDiscount") Float fromDiscount,@Param("toDiscount") Float toDiscount,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT S.MaSanPham, AVG(C.DanhGia) AS Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "LEFT JOIN Voucher V ON S.MaSanPham = V.SanPhamApDung \n" +
            "WHERE " +
                "(:fromDiscount is null or V.PhanTramKhuyenMai >= :fromDiscount) AND (:toDiscount is null or V.PhanTramKhuyenMai <= :toDiscount) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham, V.PhanTramKhuyenMai \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY V.PhanTramKhuyenMai ASC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndDiscountAndOrderByDiscountASC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("fromDiscount") Float fromDiscount,@Param("toDiscount") Float toDiscount,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT S.MaSanPham, AVG(C.DanhGia) AS Rate \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "LEFT JOIN Voucher V ON S.MaSanPham = V.SanPhamApDung \n" +
            "WHERE " +
                "(:fromDiscount is null or V.PhanTramKhuyenMai >= :fromDiscount) AND (:toDiscount is null or V.PhanTramKhuyenMai <= :toDiscount) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham, V.PhanTramKhuyenMai, S.GiaHienHanh \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY S.GiaHienHanh DESC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndDiscountAndOrderByPriceDESC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("fromDiscount") Float fromDiscount,@Param("toDiscount") Float toDiscount,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT DISTINCT S.MaSanPham, AVG(C.DanhGia) AS Rate, V.PhanTramKhuyenMai as PhanTramKhuyenMai, S.GiaHienHanh as GiaHienHanh \n" +
            "FROM SanPham S \n" +
            "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
            "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
            "LEFT JOIN Voucher V ON S.MaSanPham = V.SanPhamApDung \n" +
            "WHERE " +
                "(:fromDiscount is null or V.PhanTramKhuyenMai >= :fromDiscount) AND (:toDiscount is null or V.PhanTramKhuyenMai <= :toDiscount) " +
                "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                "AND (:productName is null or S.TenSanPham LIKE :productName) " +
                "AND (:store is null or S.NhaCungCap LIKE :store) " +
                "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                "AND (:category is null or DMSP.DanhMuc = :category) " +
                "\n" +
            "GROUP BY S.MaSanPham, V.PhanTramKhuyenMai, S.GiaHienHanh \n" +
            "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate) \n" +
            "ORDER BY S.GiaHienHanh DESC \n" +
            "OFFSET :offset ROWS \n" +
            "FETCH NEXT :pageSize ROWS ONLY ",
            nativeQuery = true)
    List<Object[]> findWithRateAndDiscountAndOrderByPriceASC(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("fromDiscount") Float fromDiscount,@Param("toDiscount") Float toDiscount,
            @Param("offset") Integer offset, @Param("pageSize") Integer pageSize
    );

    @Query(value =
            "SELECT COUNT(*) FROM " +
                "(SELECT DISTINCT S.MaSanPham\n" +
                "FROM SanPham S \n" +
                "LEFT JOIN ChiTietGioHang C ON S.MaSanPham = C.MaSanPham \n" +
                "LEFT JOIN DanhMucSanPham DMSP ON DMSP.MaDanhMucSanPham = S.DanhMucSanPham \n" +
                "LEFT JOIN Voucher V ON S.MaSanPham = V.SanPhamApDung \n" +
                "WHERE " +
//                    "(:fromDiscount is null or V.PhanTramKhuyenMai >= CAST(:fromDiscount AS FLOAT )) AND (:toDiscount is null or V.PhanTramKhuyenMai <= CAST(:toDiscount AS FLOAT)) " +
                    "(:fromDiscount is null or V.PhanTramKhuyenMai >= :fromDiscount) AND (:toDiscount is null or V.PhanTramKhuyenMai <= :toDiscount) " +
                    "AND (:fromPrice is null or S.GiaHienHanh >= :fromPrice) AND (:toPrice is null or S.GiaHienHanh <= :toPrice) " +
                    "AND (:productName is null or S.TenSanPham LIKE :productName) " +
                    "AND (:store is null or S.NhaCungCap LIKE :store) " +
                    "AND (:collection is null or S.STT_BoSuuTap = :collection) " +
                    "AND (:categoryProduct is null or S.DanhMucSanPham = :categoryProduct) " +
                    "AND (:category is null or DMSP.DanhMuc = :category) " +
                    "\n" +
                "GROUP BY S.MaSanPham\n" +
                "HAVING (:fromRate is null or AVG(C.DanhGia) >= :fromRate) AND (:toRate is null or AVG(C.DanhGia) <= :toRate)) CLAIMS \n"
            ,nativeQuery = true)
    Integer countWithRateAndDiscount(
            @Param("productName") String productName,
            @Param("store") String store, @Param("collection") Integer collection,
            @Param("category") Long category, @Param("categoryProduct") Long categoryProduct,
            @Param("fromPrice") Long fromPrice, @Param("toPrice") Long toPrice,
            @Param("fromRate") Integer fromRate,@Param("toRate") Integer toRate,
            @Param("fromDiscount") Float fromDiscount,@Param("toDiscount") Float toDiscount
    );

    @Query( "select S from SanPham S where S.maSanPham in :ids" )
    List<SanPham> findByIds(@Param("ids") List<Long> inventoryIdList);

}
