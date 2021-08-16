USE NacoTikiDB
GO

/*** PHÂN LOẠI SẢN PHẨM ***/
/*INDEX TRÊN NHÀ CUNG CẤP*/
SELECT * FROM SanPham WHERE NhaCungCap = 'Alishia6'

CREATE INDEX idx_SanPham_NhaCungCap
ON SanPham(NhaCungCap)

/*INDEX TRÊN DANH MỤC*/
SELECT * FROM SanPham WHERE DanhMucSanPham = 1

CREATE INDEX idx_SanPham_DanhMucSanPham
ON SanPham(DanhMucSanPham)


/*** PHÂN LOẠI VOUCHER ***/
SELECT * FROM Voucher WHERE LoaiVoucher = 0 OR LoaiVoucher = 1 AND NgayKetThuc < GETDATE() ORDER BY GiaTriDonHangToiThieu ASC, SoTienGiamToiDa DESC

DROP INDEX idx_Voucher_LoaiVoucher ON Voucher
CREATE INDEX idx_Voucher_LoaiVoucher
ON Voucher(LoaiVoucher, NgayBatDau, NgayKetThuc)

/*** ĐÁNH GIÁ SẢN PHẨM ***/
SELECT *
FROM ChiTietGioHang CT
WHERE CT.DanhGia < 3

DROP INDEX idx_ChiTietGioHang_DanhGia ON ChiTietGioHang
CREATE INDEX idx_ChiTietGioHang_DanhGia
ON ChiTietGioHang(DanhGia)