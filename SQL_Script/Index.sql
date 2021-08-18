USE NacoTikiDB
GO

/*** PHÂN LOẠI SẢN PHẨM ***/
/*INDEX TRÊN NHÀ CUNG CẤP*/
CREATE INDEX idx_SanPham_NhaCungCap
ON SanPham(NhaCungCap)

/*INDEX TRÊN DANH MỤC*/
CREATE INDEX idx_SanPham_DanhMucSanPham
ON SanPham(DanhMucSanPham)

/*** PHÂN LOẠI VOUCHER ***/
CREATE INDEX idx_Voucher_LoaiVoucher
ON Voucher(LoaiVoucher, NgayBatDau, NgayKetThuc)

/*** PHÂN LOẠI THEO NƠI CHỐN ***/
CREATE INDEX idx_NhaCungCap_TinhThanhPho
ON NhaCungCap(MaTinhThanhPho)

CREATE INDEX idx_SoDiaChi_TinhThanhPho
ON SoDiaChi(MaTinhThanhPho)

/*** ĐÁNH GIÁ SẢN PHẨM ***/
CREATE INDEX idx_ChiTietGioHang_DanhGia
ON ChiTietGioHang(DanhGia)