USE NacoTikiDB
GO

/*THỐNG KÊ DOANH THU*/
IF OBJECT_ID(N'ThongKe_DoanhThu') IS NOT NULL
	DROP PROCEDURE ThongKe_DoanhThu
GO

CREATE PROCEDURE ThongKe_DoanhThu
	@NhaCungCap varchar(20),
	@fromThang TINYINT,
	@fromNam SMALLINT,
	@toThang TINYINT,
	@toNam SMALLINT
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
	DECLARE @fromDate DATETIME
	SET @fromDate = CONVERT(DATETIME, CONCAT('1/', CAST(@fromThang as VARCHAR(10)), '/', CAST(@fromNam as VARCHAR(10))), 102)

	DECLARE @toDate DATETIME

	IF @toThang < 12
		BEGIN
			SET @toThang = @toThang + 1
		END
	ELSE
		BEGIN
			SET @toThang = 1
			SET @toNam = @toNam + 1
		END

	SET @toDate = CONVERT(DATETIME, CONCAT('1/', CAST(@toThang as VARCHAR(10)), '/', CAST(@toNam as VARCHAR(10))), 102)

	SELECT YEAR(D.NgayDat) AS Nam, MONTH(D.NgayDat) AS Thang, SUM(D.ThanhTien) AS TongDoanhThu, COUNT(D.MaDonHang) AS SoDon
	FROM DonHang D JOIN GioHang G ON D.GioHang = G.MaGioHang
	WHERE G.NhaCungCap = @NhaCungCap AND (D.NgayDat >= @fromDate AND D.NgayDat < @toDate)
	GROUP BY YEAR(D.NgayDat), MONTH(D.NgayDat)
	ORDER BY YEAR(D.NgayDat), MONTH(D.NgayDat)
	COMMIT TRANSACTION
END
GO

/*THỐNG KÊ LƯỢT YÊU THÍCH*/
IF OBJECT_ID(N'ThongKe_LuotYeuThich') IS NOT NULL
	DROP PROCEDURE ThongKe_LuotYeuThich
GO

CREATE PROCEDURE ThongKe_LuotYeuThich
	@NhaCungCap varchar(20)
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
	SELECT SPYT.SanPham, SP.TenSanPham, N.TenNhaCungCap, COUNT(SPYT.KhachHang) AS YeuThich
	FROM SanPhamYeuThich SPYT JOIN SanPham SP ON SPYT.SanPham = SP.MaSanPham
		JOIN NhaCungCap N ON SP.NhaCungCap = N.Username
	WHERE SP.NhaCungCap = @NhaCungCap
	GROUP BY SPYT.SanPham, SP.TenSanPham, N.TenNhaCungCap
	ORDER BY COUNT(SPYT.KhachHang)
	COMMIT TRANSACTION
END
GO

EXEC ThongKe_LuotYeuThich 'Abbie2023'
go

/*THỐNG KÊ LƯỢT YÊU THÍCH*/
IF OBJECT_ID(N'ThongKe_LuotMua') IS NOT NULL
	DROP PROCEDURE ThongKe_LuotMua
GO

CREATE PROCEDURE ThongKe_LuotMua
	@NhaCungCap varchar(20)
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
	SELECT CTGH.MaSanPham, SP.TenSanPham, N.TenNhaCungCap, SUM(CTGH.SoLuongMua) AS BanRa
	FROM ChiTietGioHang CTGH JOIN SanPham SP ON CTGH.MaSanPham = SP.MaSanPham
		JOIN NhaCungCap N ON SP.NhaCungCap = N.Username
	WHERE SP.NhaCungCap = @NhaCungCap
	GROUP BY CTGH.MaSanPham, SP.TenSanPham, N.TenNhaCungCap
	ORDER BY SUM(CTGH.SoLuongMua) DESC
	COMMIT TRANSACTION
END
GO

EXEC ThongKe_LuotMua 'Abbie2023'
go

/*THỐNG KÊ PHƯƠNG THỨC THANH TOÁN*/
IF OBJECT_ID(N'ThongKe_PTTT') IS NOT NULL
	DROP PROCEDURE ThongKe_PTTT
GO

CREATE PROCEDURE ThongKe_PTTT
	@fromThang TINYINT,
	@fromNam SMALLINT,
	@toThang TINYINT,
	@toNam SMALLINT
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
	DECLARE @fromDate DATETIME
	SET @fromDate = CONVERT(DATETIME, CONCAT('1/', CAST(@fromThang as VARCHAR(10)), '/', CAST(@fromNam as VARCHAR(10))), 102)

	DECLARE @toDate DATETIME

	IF @toThang < 12
		BEGIN
			SET @toThang = @toThang + 1
		END
	ELSE
		BEGIN
			SET @toThang = 1
			SET @toNam = @toNam + 1
		END

	SET @toDate = CONVERT(DATETIME, CONCAT('1/', CAST(@toThang as VARCHAR(10)), '/', CAST(@toNam as VARCHAR(10))), 102)

	SELECT T.MaCongThanhToan, T.TenCongThanhToan, COUNT(D.MaDonHang) AS SoLuong
	FROM DonHang D JOIN GiaoDich G ON D.MaGiaoDich = G.MaGiaoDich
		JOIN ThongTinCongThanhToan T ON G.CongThanhToan = T.MaCongThanhToan
	WHERE D.MaGiaoDich IS NOT NULL AND (D.NgayDat >= @fromDate AND D.NgayDat < @toDate)
	GROUP BY T.MaCongThanhToan, T.TenCongThanhToan
	COMMIT TRANSACTION
END
GO

EXEC ThongKe_PTTT 1, 2020, 5, 2021
go

/*THỐNG KÊ HÌNH THỨC VẬN CHUYỂN*/
IF OBJECT_ID(N'ThongKe_PTTT') IS NOT NULL
	DROP PROCEDURE ThongKe_PTTT
GO

CREATE PROCEDURE ThongKe_PTTT
	@fromThang TINYINT,
	@fromNam SMALLINT,
	@toThang TINYINT,
	@toNam SMALLINT
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
	DECLARE @fromDate DATETIME
	SET @fromDate = CONVERT(DATETIME, CONCAT('1/', CAST(@fromThang as VARCHAR(10)), '/', CAST(@fromNam as VARCHAR(10))), 102)

	DECLARE @toDate DATETIME

	IF @toThang < 12
		BEGIN
			SET @toThang = @toThang + 1
		END
	ELSE
		BEGIN
			SET @toThang = 1
			SET @toNam = @toNam + 1
		END

	SET @toDate = CONVERT(DATETIME, CONCAT('1/', CAST(@toThang as VARCHAR(10)), '/', CAST(@toNam as VARCHAR(10))), 102)

	SELECT V.MaHinhThucVanChuyen, V.TenHinhThucVanChuyen, COUNT(D.MaDonHang) AS SoLuong
	FROM DonHang D JOIN HinhThucVanChuyen V ON D.HinhThucVanChuyen = V.MaHinhThucVanChuyen
	WHERE (D.NgayDat >= @fromDate AND D.NgayDat < @toDate)
	GROUP BY V.MaHinhThucVanChuyen, V.TenHinhThucVanChuyen
	COMMIT TRANSACTION
END
GO

EXEC ThongKe_PTTT 1, 2020, 5, 2021
go

/*THỐNG KÊ CỬA HÀNG THEO ĐÁNH GIÁ*/
IF OBJECT_ID(N'ThongKe_CuaHang_DanhGia') IS NOT NULL
	DROP PROCEDURE ThongKe_CuaHang_DanhGia
GO

CREATE PROCEDURE ThongKe_CuaHang_DanhGia
	@fromThang TINYINT,
	@fromNam SMALLINT,
	@toThang TINYINT,
	@toNam SMALLINT
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
	DECLARE @fromDate DATETIME
	SET @fromDate = CONVERT(DATETIME, CONCAT('1/', CAST(@fromThang as VARCHAR(10)), '/', CAST(@fromNam as VARCHAR(10))), 102)

	DECLARE @toDate DATETIME

	IF @toThang < 12
		BEGIN
			SET @toThang = @toThang + 1
		END
	ELSE
		BEGIN
			SET @toThang = 1
			SET @toNam = @toNam + 1
		END

	SET @toDate = CONVERT(DATETIME, CONCAT('1/', CAST(@toThang as VARCHAR(10)), '/', CAST(@toNam as VARCHAR(10))), 102)

	SELECT GH.NhaCungCap, AVG(CTGH.DanhGia) AS DanhGia
	FROM DonHang D JOIN GioHang GH ON D.GioHang = GH.MaGioHang
		JOIN ChiTietGioHang CTGH ON D.GioHang = CTGH.MaGioHang
	WHERE D.NgayDat >= @fromDate AND D.NgayDat < @toDate
	GROUP BY GH.NhaCungCap
	ORDER BY AVG(CTGH.DanhGia) DESC
	COMMIT TRANSACTION
END
GO


EXEC ThongKe_CuaHang_DanhGia 1, 2020, 5, 2021
GO

/*THỐNG KÊ CỬA HÀNG THEO ĐÁNH GIÁ*/
IF OBJECT_ID(N'ThongKe_CuaHang_KhieuNai') IS NOT NULL
	DROP PROCEDURE ThongKe_CuaHang_KhieuNai
GO

CREATE PROCEDURE ThongKe_CuaHang_KhieuNai
	@fromThang TINYINT,
	@fromNam SMALLINT,
	@toThang TINYINT,
	@toNam SMALLINT
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
	DECLARE @fromDate DATETIME
	SET @fromDate = CONVERT(DATETIME, CONCAT('1/', CAST(@fromThang as VARCHAR(10)), '/', CAST(@fromNam as VARCHAR(10))), 102)

	DECLARE @toDate DATETIME

	IF @toThang < 12
		BEGIN
			SET @toThang = @toThang + 1
		END
	ELSE
		BEGIN
			SET @toThang = 1
			SET @toNam = @toNam + 1
		END

	SET @toDate = CONVERT(DATETIME, CONCAT('1/', CAST(@toThang as VARCHAR(10)), '/', CAST(@toNam as VARCHAR(10))), 102)

	SELECT GH.NhaCungCap, COUNT(D.MaDonHang) AS SoLuotKhieuNai
	FROM DonHang D JOIN GioHang GH ON D.GioHang = GH.MaGioHang
		JOIN KhieuNaiDonHang K ON D.MaDonHang = k.DonHang
	WHERE D.NgayDat >= @fromDate AND D.NgayDat < @toDate
	GROUP BY GH.NhaCungCap
	ORDER BY COUNT(D.MaDonHang) DESC
	COMMIT TRANSACTION
END
GO

EXEC ThongKe_CuaHang_KhieuNai 1, 2020, 5, 2021
GO

/*THÊM HÓA ĐƠN*/
IF OBJECT_ID(N'Them_HoaDon') IS NOT NULL
	DROP PROCEDURE Them_HoaDon
GO

CREATE PROCEDURE Them_HoaDon
	@MaGioHang BIGINT,
	@HinhThucVanChuyen BIGINT
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL REPEATABLE READ
	BEGIN TRANSACTION
		IF EXISTS (SELECT * FROM ChiTietGioHang CT JOIN SanPham S ON CT.MaSanPham = S.MaSanPham WHERE CT.MaGioHang = @MaGioHang AND CT.SoLuongMua > S.SoLuongTon)
		BEGIN
			PRINT(N'Đơn hàng không thể tạo vì số lượng sản phẩm vượt quá số lượng tồn')
			ROLLBACK TRANSACTION
		END
		UPDATE SanPham SET SoLuongTon = SoLuongTon - CT.SoLuongMua FROM ChiTietGioHang CT JOIN SanPham S ON CT.MaSanPham = S.MaSanPham WHERE CT.MaGioHang = @MaGioHang
		INSERT INTO DonHang (TrangThaiThanhToan, NgayDat, ThanhTien, GioHang, MaGiaoDich, HinhThucVanChuyen, PhiVanChuyen) VALUES (0, GETDATE(), 0, @MaGioHang, NULL, @HinhThucVanChuyen, 0)
		UPDATE GioHang SET TrangThaiDatHang = 1 WHERE MaGioHang = @MaGioHang
	COMMIT TRANSACTION
END
GO

/*** THỐNG KÊ TỶ LỆ ĐƠN HÀNG THÀNH CÔNG ***/
IF OBJECT_ID(N'ThongKe_TyLeDonHangThanhCong') IS NOT NULL
	DROP PROCEDURE ThongKe_TyLeDonHangThanhCong
GO

CREATE PROCEDURE ThongKe_TyLeDonHangThanhCong
@year INT
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
	BEGIN TRANSACTION
		DECLARE @TongDonHangThanhCong INT
		SET @TongDonHangThanhCong = 0

		IF @year = 2016
		BEGIN
			SET @year = 1
		END
		ELSE IF @year = 2017
		BEGIN
			SET @year = 2
		END
		ELSE IF @year = 2018
		BEGIN
			SET @year = 3
		END
		ELSE IF @year = 2019
		BEGIN
			SET @year = 4
		END
		ELSE IF @year = 2020
		BEGIN
			SET @year = 5
		END
		ELSE IF @year = 2021
		BEGIN
			SET @year = 6
		END
		ELSE
		BEGIN
			PRINT(N'Năm không hợp lệ')
			ROLLBACK TRANSACTION
		END

		SELECT COUNT(CASE WHEN TrangThaiThanhToan = 1 THEN 1 END) AS SoLuongDonHangThanhCong, COUNT(MaDonHang) AS SoLuongDonHang
		FROM DonHangTheoThang WHERE $PARTITION.Partition_By_Year(NgayDat) = @year

	COMMIT TRANSACTION
END
GO

EXEC ThongKe_TyLeDonHangThanhCong 2020

/*** Cập nhật số lượng hàng tồn ***/
IF OBJECT_ID(N'update_HangTon') IS NOT NULL
	DROP PROCEDURE ThongKe_TyLeDonHangThanhCong
GO
CREATE PROCEDURE update_HangTon
	@MaGioHang BIGINT
AS
BEGIN
	SET TRANSACTION ISOLATION LEVEL REPEATABLE READ
	BEGIN TRANSACTION
		IF EXISTS (SELECT * FROM ChiTietGioHang CT JOIN SanPham S ON CT.MaSanPham = S.MaSanPham WHERE CT.MaGioHang = @MaGioHang AND CT.SoLuongMua > S.SoLuongTon)
		BEGIN
			PRINT(N'Đơn hàng không thể tạo vì số lượng sản phẩm vượt quá số lượng tồn')
			ROLLBACK TRANSACTION
		END
		UPDATE SanPham SET SoLuongTon = SoLuongTon - CT.SoLuongMua FROM ChiTietGioHang CT JOIN SanPham S ON CT.MaSanPham = S.MaSanPham WHERE CT.MaGioHang = @MaGioHang
	COMMIT TRANSACTION
END