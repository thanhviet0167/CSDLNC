Use  NacoTikiDB
go

-- Cau 1

IF OBJECT_ID(N'KT_NgayTheoDoi') IS NOT NULL
	DROP TRIGGER KT_NgayTheoDoi
GO

Create trigger KT_NgayTheoDoi on TheoDoiNhaCungCap for insert, update
	as
	begin
		if(update(NgayTheoDoi))
			Declare @c int
			Select @c = count(*) from inserted i join NhaCungCap ncc on i.MaKhachHang = ncc.Username
					where i.NgayTheoDoi < ncc.NgayThamGia
			if(@c > 0)
				begin
					print(N'Ngày theo dõi phải sau ngày tham gia');
					rollback transaction
				end

		end
go

DELETE FROM NhaCungCap WHERE Username = '111'
DELETE FROM KhachHang WHERE Username = '111'
DELETE TinhThanhPho WHERE MaTinhThanhPho = 1
INSERT INTO TinhThanhPho VALUES(1, N'Ha Noi')

INSERT INTO KhachHang VALUES ('111', '111', 'ABC', 'Email', 0, '05/04/1996', 'url-hinh-anh', '0999333222')
INSERT INTO NhaCungCap VALUES('111', 'ABCD', 'mo ta', '04/04/2000', '0922999333', 'BinhThanh', 1)

DELETE TheoDoiNhaCungCap WHERE MaKhachHang = '111'
INSERT INTO TheoDoiNhaCungCap VALUES ('111','111','04/04/2000')

-- Cau 2

IF OBJECT_ID(N'KT_NgayThanhToan') IS NOT NULL
	DROP TRIGGER KT_NgayThanhToan
GO

Create trigger KT_NgayThanhToan on GiaoDich for insert, update
as
	begin

		if(update(NgayThanhToan))
			begin
				declare @c int;
				select @c = count(*) from inserted i join ThongTinThanhToan tt on i.TaiKhoanThanhToan = tt.TaiKhoanThanhToan and i.CongThanhToan = tt.CongThanhToan
					where  tt.NgayHetHan IS NOT NULL AND i.NgayThanhToan > tt.NgayHetHan
					if(@c > 0)
					begin
						print(N'Ngày thanh toán phải trước ngày hết hạn thẻ');
						rollback transaction
					end
			end
	end

	go

DELETE PhuongThucThanhToan WHERE Username = '111'
DELETE ThongTinThanhToan WHERE TaiKhoanThanhToan = '111'
DELETE ThongTinCongThanhToan WHERE MaCongThanhToan = 'vp'
INSERT INTO ThongTinCongThanhToan VALUES('vp','VPBANK')
INSERT INTO ThongTinThanhToan VALUES('111','vp',1,'ABC','chinhanh','loaithe','08/02/2021')
INSERT INTO PhuongThucThanhToan VALUES('111','111','vp',1)

DELETE GiaoDich WHERE MaGiaoDich = 1
INSERT INTO GiaoDich VALUES(1,100000,1,'111','111','vp','08/02/2020')

-- Câu 3 : thông qua test
IF OBJECT_ID(N'KT_NgayDat_ThanhToan') IS NOT NULL
	DROP TRIGGER KT_NgayDat_ThanhToan
GO

Create trigger KT_NgayDat_ThanhToan on GiaoDich for insert, update
	as
		begin
			if(update(NgayThanhToan))
				begin
					declare @c int;
					select @c = count(*) from inserted i join DonHang dh on i.MaGiaoDich = dh.MaGiaoDich
						where i.NgayThanhToan < dh.NgayDat
					if(@c > 0)
					begin
						print (N'Ngày thanh toán phải sau ngày đặt hàng');
						rollback transaction
					end
				end

		end
go

update GiaoDich set NgayThanhToan = N'02-02-2022'

-- Câu 4 : thông qua test

IF OBJECT_ID(N'KT_NgayDanhGia') IS NOT NULL
	DROP TRIGGER KT_NgayDanhGia
GO

Create trigger KT_NgayDanhGia on ChiTietGioHang for update
as
	begin
	if(update(ThoiGianDanhGia))
		begin
			declare @c int
			select @c = count(*) from inserted i join GioHang gh on i.MaGioHang = gh.MaGioHang 
				join DonHang dh on gh.MaGioHang = dh.GioHang join ThongTinVanChuyen ttvc on dh.MaDonHang = ttvc.DonHang
				where i.ThoiGianDanhGia < ttvc.ThoiGianVanChuyen and ttvc.TrangThaiVanChuyen = N'Đã giao'
			if(@c > 0)
				begin
					print (N'Ngày đánh giá phải sau ngày giao hàng');
					rollback transaction
				end
		end
	end
go

update ChiTietGioHang set ThoiGianDanhGia = N'01-01-2021'


-- Câu 5 : thông qua

IF OBJECT_ID(N'KT_TTDaGiao_KhieuNai') IS NOT NULL
	DROP TRIGGER KT_TTDaGiao_KhieuNai
GO

Create trigger KT_TTDaGiao_KhieuNai on KhieuNaiDonHang for insert, update
as
	begin
		if(update(NgayTaoKhieuNai))
			declare @c int
			SET @c = 0
			select @c = count(*) from inserted i 
				join ThongTinVanChuyen ttvc on i.DonHang = ttvc.DonHang 
				where ttvc.TrangThaiVanChuyen = N'Chưa giao'
			if(@c > 0)
				begin
					print (N'Đơn khiếu nại phải được tạo sau khi đã giao hàng');
					rollback transaction
				end
	end
go

update KhieuNaiDonHang set TrangThaiXuLy = 0

-- Câu 6 : test ok

IF OBJECT_ID(N'KT_NgayKhieuNai') IS NOT NULL
	DROP TRIGGER KT_NgayKhieuNai
GO

Alter trigger KT_NgayKhieuNai on KhieuNaiDonHang for insert, update
as
	begin
	if update(NgayTaoKhieuNai)
		begin
			declare @c int
			select @c = count(*) FROM inserted i JOIN ThongTinVanChuyen ttvc on i.DonHang = ttvc.DonHang
				WHERE ttvc.TrangThaiVanChuyen = N'Đã giao' AND (DATEDIFF(day, ttvc.ThoiGianVanChuyen, i.NgayTaoKhieuNai) < 0 OR DATEDIFF(day, ttvc.ThoiGianVanChuyen, i.NgayTaoKhieuNai) > 7)
				print(@c)
			if(@c > 0)
				begin
					print (N'Đơn khiếu nại phải được tạo trong vòng 7 ngày sau khi đã giao hàng');
					rollback transaction
				end
		end
	end
go

select * FROM KhieuNaiDonHang i JOIN ThongTinVanChuyen ttvc on i.DonHang = ttvc.DonHang
				WHERE ttvc.TrangThaiVanChuyen = N'Đã giao' AND (DATEDIFF(day, ttvc.ThoiGianVanChuyen, i.NgayTaoKhieuNai) < 0 OR DATEDIFF(day, ttvc.ThoiGianVanChuyen, i.NgayTaoKhieuNai) > 7)
update KhieuNaiDonHang set NgayTaoKhieuNai = N'01-17-2021'

-- Câu 7 : test ok

IF OBJECT_ID(N'KT_NgayThanhToan_GiaoDich') IS NOT NULL
	DROP TRIGGER KT_NgayThanhToan_GiaoDich
GO

Create trigger KT_NgayThanhToan_GiaoDich on ThongTinVanChuyen for insert, update
as
	begin
		if(update(ThoiGianVanChuyen))
			if(exists(select * from inserted i join DonHang dh on i.DonHang = dh.MaDonHang WHERE dh.TrangThaiThanhToan != 1))
			begin
				print (N'Chỉ bắt đầu giao hàng khi đơn đã thanh toán');
				rollback transaction
			end
	end

go

update ThongTinVanChuyen set ThoiGianVanChuyen = N'02-03-2021'

-- Câu 8 : test ok
IF OBJECT_ID(N'TrangThaiThanhToanDonHang') IS NOT NULL
	DROP TRIGGER TrangThaiThanhToanDonHang
GO

CREATE TRIGGER TrangThaiThanhToanDonHang ON GiaoDich for update
AS
	BEGIN
		IF UPDATE(TrangThaiThanhToan)
			BEGIN
				UPDATE DonHang SET TrangThaiThanhToan = 1 FROM DonHang dh JOIN inserted i ON dh.MaGiaoDich = i.MaGiaoDich WHERE i.TrangThaiThanhToan = 1
			END
	END
GO
update GiaoDich set TrangThaiThanhToan = 1


-- Câu 9 : test ok
IF OBJECT_ID(N'KT_SLTon') IS NOT NULL
	DROP TRIGGER KT_SLTon
GO

Create trigger KT_SLTon on ChiTietGioHang for insert, update
as
	begin
		if(update(SoLuongMua))
		declare @c int
		select @c = count(*) from inserted i join SanPham sp on i.MaGioHang = sp.MaSanPham 
			where i.SoLuongMua > sp.SoLuongTon

		if(@c > 0)
			begin
				print (N'Số lượng mua không vượt quá số lượng tồn kho của sản phẩm');
				rollback transaction
			end

	end
go

update ChiTietGioHang set SoLuongMua = 2

-- Câu 10: test ok
IF OBJECT_ID(N'KT_SLQuaTangKem') IS NOT NULL
	DROP TRIGGER KT_SLQuaTangKem
GO

Create trigger KT_SLQuaTangKem on ChiTietQuaTang for insert, update
as
	begin
		if(update(SoLuongTangKem))
		declare @c int
		select @c = count(*) from inserted i join SanPham sp on i.SanPhamTangKem = sp.MaSanPham 
			where i.SoLuongTangKem > sp.SoLuongTon

		if(@c > 0)
			begin
				print (N'Số lượng tặng kèm không vượt quá số lượng tồn kho của sản phẩm');
				rollback transaction
			end

	end
go

update ChiTietQuaTang set SoLuongTangKem = 2

-- Câu 11 : test ok

IF OBJECT_ID(N'KT_SLQuaTangKem_2') IS NOT NULL
	DROP TRIGGER KT_SLQuaTangKem_2
GO

Create trigger KT_SLQuaTangKem_2 on ChiTietQuaTang for insert, update
as
	begin
		if(update(SoLuongTangKem))
			if(exists(select * from inserted i join ChiTietVoucher ctvc on i.MaVoucher = ctvc.MaVoucher 
			where i.SanPhamTangKem = ctvc.SanPhamTangKem and i.SoLuongTangKem > ctvc.SoLuongApDungToiDa
			))
				begin
					print(N'Sản phẩm tặng kèm không vượt quá số lượng áp dụng tối đa')
					rollback tran
				end
	end
go

update ChiTietQuaTang set SoLuongTangKem = 7


-- Câu 12 : lỗi ràng buộc
IF OBJECT_ID(N'KT_GiaBanTangKem_CTQT') IS NOT NULL
	DROP TRIGGER KT_GiaBanTangKem_CTQT
GO

Create trigger KT_GiaBanTangKem_CTQT on ChiTietQuaTang FOR insert, update
as
	begin
		if(UPDATE(MaVoucher) OR UPDATE(SanPhamTangKem))
			BEGIN
				DECLARE @maVoucher BIGINT
				DECLARE @sanPhamTangKem BIGINT
				DECLARE @phanTramGiamGia FLOAT
				SELECT @maVoucher = i.MaVoucher, @sanPhamTangKem = i.SanPhamTangKem FROM inserted i
				SELECT @phanTramGiamGia = 1 - (SELECT ct.PhanTramGiamGia FROM ChiTietVoucher ct WHERE ct.MaVoucher = @maVoucher AND ct.SanPhamTangKem = @sanPhamTangKem)
				UPDATE ChiTietQuaTang SET GiaBanTangKem = CAST(@phanTramGiamGia * sp.GiaHienHanh AS BIGINT) FROM SanPham sp WHERE sp.MaSanPham = @sanPhamTangKem
			END
	end
go

update ChiTietQuaTang set MaVoucher = 1

-- Câu 13 : test ok
IF OBJECT_ID(N'KT_PhiVanChuyen') IS NOT NULL
	DROP TRIGGER KT_PhiVanChuyen
GO

Create trigger KT_PhiVanChuyen on ThongTinHinhThucVanChuyen for insert, update
as
	begin
		if(update(PhiGiaoHang))
			if(exists(
				select * from ThongTinHinhThucVanChuyen htvc
				where htvc.PhamViVanChuyen = 0 and htvc.PhiGiaoHang > (Select 
					htvc2.PhiGiaoHang from ThongTinHinhThucVanChuyen htvc2
					where htvc2.MaHinhThucVanChuyen != htvc.MaHinhThucVanChuyen
					and htvc2.PhamViVanChuyen = 1)
			))
				begin
					print(N'Phí giao hàng ngoại tỉnh phải lớn hơn nội tỉnh')
					rollback tran
				end
	end
go

update ThongTinHinhThucVanChuyen set PhiGiaoHang = 100 where PhamViVanChuyen = 0

-- Câu 14 : test ok
IF OBJECT_ID(N'KT_Tgian_VanChuyen') IS NOT NULL
	DROP TRIGGER KT_Tgian_VanChuyen
GO

Create trigger KT_Tgian_VanChuyen on ThongTinHinhThucVanChuyen for insert, update
as
	begin
		if(update(ThoiGianGiaoHang))
			if(exists(
				select * from ThongTinHinhThucVanChuyen htvc
				where htvc.PhamViVanChuyen = 0 and htvc.ThoiGianGiaoHang > (Select 
					htvc2.ThoiGianGiaoHang from ThongTinHinhThucVanChuyen htvc2
					where htvc2.MaHinhThucVanChuyen != htvc.MaHinhThucVanChuyen
					and htvc2.PhamViVanChuyen = 1)
			))
				begin
					print(N'Thời gian giao hàng ngoại tỉnh phải lớn hơn nội tỉnh')
					rollback tran
				end
	end
go

update ThongTinHinhThucVanChuyen set ThoiGianGiaoHang = 120 where MaHinhThucVanChuyen = 1
Select * from ThongTinHinhThucVanChuyen

-- Câu 15 : test ok
IF OBJECT_ID(N'CapNhat_PhiVanChuyen') IS NOT NULL
	DROP TRIGGER CapNhat_PhiVanChuyen
GO

CREATE TRIGGER CapNhat_PhiVanChuyen ON DonHang for insert, update
AS
	BEGIN
		IF (UPDATE(HinhThucVanChuyen))
			BEGIN
				DECLARE @noiGiaoHang TINYINT
				DECLARE @noiNhanHang TINYINT
				DECLARE @gioHang BIGINT
				DECLARE @donHang BIGINT
				SELECT @gioHang = i.GioHang, @donHang = i.MaDonHang FROM inserted i
				SELECT @noiGiaoHang = ncc.MaTinhThanhPho FROM GioHang g JOIN NhaCungCap ncc ON g.NhaCungCap = ncc.Username WHERE g.MaGioHang = @gioHang
				SELECT @noiNhanHang = sdc.MaTinhThanhPho FROM GioHang g JOIN SoDiaChi sdc ON g.KhachHang = sdc.Username AND g.STT_SoDiaChi = sdc.STT WHERE g.MaGioHang = @gioHang

				IF @noiGiaoHang != @noiNhanHang
					BEGIN
						UPDATE DonHang SET PhiVanChuyen = ttvc.PhiGiaoHang
						FROM DonHang dh JOIN ThongTinHinhThucVanChuyen ttvc ON dh.HinhThucVanChuyen = ttvc.MaHinhThucVanChuyen WHERE dh.MaDonHang = @donHang AND ttvc.PhamViVanChuyen = 1
					END
				ELSE
					BEGIN
						UPDATE DonHang SET PhiVanChuyen = ttvc.PhiGiaoHang
						FROM DonHang dh JOIN ThongTinHinhThucVanChuyen ttvc ON dh.HinhThucVanChuyen = ttvc.MaHinhThucVanChuyen WHERE dh.MaDonHang = @donHang AND ttvc.PhamViVanChuyen = 0
					END
			END
	END
GO

update DonHang set HinhThucVanChuyen = 1

select * from DonHang

-- Câu 16 + Câu 17 : test ok
IF OBJECT_ID(N'CapNhat_GiaBanThucTe_GiaGiam') IS NOT NULL
	DROP TRIGGER CapNhat_GiaBanThucTe_GiaGiam
GO

Create TRIGGER CapNhat_GiaBanThucTe_GiaGiam ON ChiTietGioHang FOR INSERT, UPDATE
AS
	BEGIN
		IF(UPDATE(MaSanPham) OR UPDATE(SoLuongMua))
			BEGIN
				DECLARE @SanPham BIGINT
				DECLARE @SoLuongMua SMALLINT
				DECLARE @SoLuongSi SMALLINT
				DECLARE @SoLuongGiam SMALLINT
				DECLARE @GiaHH BIGINT
				DECLARE @GiaSi BIGINT
				DECLARE @GiaGiam BIGINT
				SELECT @SanPham = i.MaSanPham, @SoLuongMua = i.SoLuongMua FROM inserted i
				SELECT @SoLuongSi = sp.SoLuongSi, @GiaHH = sp.GiaHienHanh, @GiaSi = sp.GiaSi, @SoLuongGiam = sp.SoLuongGiamGia, @GiaGiam = sp.GiaGiam
				FROM SanPham sp WHERE sp.MaSanPham = @SanPham
				
				IF @SoLuongSi IS NULL
					BEGIN
						SET @SoLuongSi = 32767
					END

				IF @SoLuongMua < @SoLuongSi
					BEGIN
						UPDATE ChiTietGioHang SET GiaBanThucTe = @GiaHH
					END
				ELSE
					BEGIN
						UPDATE ChiTietGioHang SET GiaBanThucTe = @GiaSi
					END

				IF @SoLuongGiam IS NULL
					BEGIN
						UPDATE ChiTietGioHang SET GiaGiam = 0
					END
				ELSE
					BEGIN
						IF @SoLuongMua < @SoLuongGiam
						BEGIN
							UPDATE ChiTietGioHang SET GiaGiam = 0
						END
						ELSE IF @SoLuongMua < @SoLuongSi
						BEGIN
							UPDATE ChiTietGioHang SET GiaGiam = @GiaGiam
						END
					END
			END
	END
GO

Select * from ChiTietGioHang
Update ChiTietGioHang set SoLuongMua = 21
Select * from ChiTietGioHang

-- Câu 18 : test ok
IF OBJECT_ID(N'CapNhat_TongTienChuaKM') IS NOT NULL
	DROP TRIGGER CapNhat_TongTienChuaKM
GO

CREATE TRIGGER CapNhat_TongTienChuaKM ON ChiTietGioHang AFTER INSERT, UPDATE, DELETE
AS
	IF (UPDATE(SoLuongMua) OR UPDATE(GiaBanThucTe))
	BEGIN
		DECLARE @GiaGiam BIGINT
		SET @GiaGiam = 0
				
		DECLARE @GioHang BIGINT
		SET @GioHang = -1

		SELECT @GioHang = i.MaGioHang FROM inserted i
		
		IF (@GioHang < 0)
			BEGIN
				SELECT @GioHang = d.MaGioHang FROM deleted d
			END

		UPDATE GioHang SET TongTienChuaKhuyenMai = (SELECT SUM(Ctgh.SoLuongMua * Ctgh.GiaBanThucTe - Ctgh.GiaGiam)
														FROM ChiTietGioHang Ctgh WHERE Ctgh.MaGioHang = @GioHang) WHERE MaGioHang = @GioHang
	END
GO

select * from GioHang
update ChiTietGioHang set SoLuongMua = 9
select * from GioHang


-- Câu 19 : test ok
IF OBJECT_ID(N'CapNhat_TongTienQuaTang') IS NOT NULL
	DROP TRIGGER CapNhat_TongTienQuaTang
GO

CREATE TRIGGER CapNhat_TongTienQuaTang ON ChiTietGioHang AFTER INSERT, UPDATE, DELETE
AS
	IF (UPDATE(SoLuongMua) OR UPDATE(GiaBanThucTe))
	BEGIN
		DECLARE @GiaGiam BIGINT
		SET @GiaGiam = 0
				
		DECLARE @GioHang BIGINT
		SET @GioHang = -1

		SELECT @GioHang = i.MaGioHang FROM inserted i
		
		IF (@GioHang < 0)
			BEGIN
				SELECT @GioHang = d.MaGioHang FROM deleted d
			END

		UPDATE GioHang SET TongTienQuaTang = (SELECT SUM(Ctqt.SoLuongTangKem * Ctqt.GiaBanTangKem)
														FROM ChiTietQuaTang Ctqt WHERE Ctqt.MaGioHang = @GioHang) WHERE MaGioHang = @GioHang
	END
GO

select * from GioHang
update ChiTietGioHang set SoLuongMua = 7
select * from GioHang

-- Câu 20 : test ok
IF OBJECT_ID(N'CapNhat_ThanhTien_DonHang') IS NOT NULL
	DROP TRIGGER CapNhat_ThanhTien_DonHang
GO

Create trigger CapNhat_ThanhTien_DonHang on GioHang after insert, update
as
	begin
		if(update(TongTienChuaKhuyenMai) OR UPDATE(TongTienQuaTang) or update(SoTienGiamThucTe))
			DECLARE @GioHang BIGINT
			SELECT @GioHang = i.MaGioHang FROM inserted i
			update DonHang set ThanhTien = (select gh.TongTienChuaKhuyenMai + gh.TongTienQuaTang - gh.SoTienGiamThucTe FROM GioHang gh WHERE gh.MaGioHang = @GioHang)
	end
go

select * from DonHang
update GioHang set TongTienChuaKhuyenMai = 2000
select * from DonHang
select * from GioHang

-- Câu 21 : test ok
IF OBJECT_ID(N'CapNhat_TongTienGiaoDich') IS NOT NULL
	DROP TRIGGER CapNhat_TongTienGiaoDich
GO

Create trigger CapNhat_TongTienGiaoDich on DonHang after INSERT, UPDATE
as
	begin
		if(update(ThanhTien) or update(PhiVanChuyen))
			BEGIN
				DECLARE @giaodich BIGINT
				SET @giaodich = -1
				SELECT @giaodich = i.MaGiaoDich FROM inserted i

				UPDATE GiaoDich set TongTien = 
				(SELECT SUM(dh.ThanhTien + dh.PhiVanChuyen) FROM DonHang dh WHERE dh.MaGiaoDich = @giaodich)
			END		
	end
go
select * from GiaoDich
select * from DonHang
update DonHang set PhiVanChuyen = 100

select * from GiaoDich

-- Câu 22

IF OBJECT_ID(N'KT_BangLuong') IS NOT NULL
	DROP TRIGGER KT_BangLuong
GO

Create trigger KT_BangLuong on BangLuong after insert, update
as
	begin
		
		if(update(SoNgayCong))
		declare @luongtam bigint, @songaycong tinyint, @songaycongthoathuan tinyint
		-- Số ngày công bé
		update BangLuong set LuongThucNhan = ((select i.SoNgayCong from inserted i join HopDong hd -- Tính lương tạm
												on i.HopDongLaoDong = hd.MaHopDong where i.SoNgayCong <
												hd.SoNgayCongThangThoaThuan and i.NhanVien = BangLuong.NhanVien)*(select 
												i.LuongMotNgayCong from inserted i join HopDong hd 
												on i.HopDongLaoDong = hd.MaHopDong 
												where i.SoNgayCong < hd.SoNgayCongThangThoaThuan and i.NhanVien = BangLuong.NhanVien)
												)*(1-BangLuong.BaoHiemXaHoi-BangLuong.Thue) + BangLuong.Thuong + 
												(select pc.SoTienPhuCap  from inserted i join LuongPhuCap lpc on i.NhanVien = lpc.NhanVien join PhuCap pc
												on lpc.MaPhuCap = pc.MaPhuCap
												where BangLuong.HopDongLaoDong = i.HopDongLaoDong)
		-- Số ngày công lớn hơn
		update BangLuong set LuongThucNhan = ( (select hd.LuongThangThoaThuan from inserted i join HopDong hd -- Tính lương tạm
												on i.HopDongLaoDong = hd.MaHopDong where i.SoNgayCong >
												hd.SoNgayCongThangThoaThuan and i.NhanVien = BangLuong.NhanVien) +
												((select i.SoNgayCong from inserted i join HopDong hd -- Tính lương thưởng từ số ngày dư
												on i.HopDongLaoDong = hd.MaHopDong where i.SoNgayCong >
												hd.SoNgayCongThangThoaThuan and i.NhanVien = BangLuong.NhanVien)-(select 
												i.LuongMotNgayCong from inserted i join HopDong hd 
												on i.HopDongLaoDong = hd.MaHopDong 
												where i.SoNgayCong > hd.SoNgayCongThangThoaThuan and i.NhanVien = BangLuong.NhanVien))*(
												select i.LuongMotNgayCong from inserted i join HopDong hd -- Lương một ngày công
												on i.HopDongLaoDong = hd.MaHopDong where i.SoNgayCong >
												hd.SoNgayCongThangThoaThuan and i.NhanVien = BangLuong.NhanVien
												)
												)*(1-BangLuong.BaoHiemXaHoi-BangLuong.Thue) + BangLuong.Thuong + 
												(select pc.SoTienPhuCap  from inserted i join LuongPhuCap lpc on i.NhanVien = lpc.NhanVien join PhuCap pc
												on lpc.MaPhuCap = pc.MaPhuCap
												where BangLuong.HopDongLaoDong = i.HopDongLaoDong)
		-- Số ngày công bằng số ngày thỏa thuận
		update BangLuong set LuongThucNhan = (select hd.LuongThangThoaThuan from inserted i join HopDong hd -- Tính lương tạm
												on i.HopDongLaoDong = hd.MaHopDong where i.SoNgayCong =
												hd.SoNgayCongThangThoaThuan and i.NhanVien = BangLuong.NhanVien)*(1-BangLuong.BaoHiemXaHoi-BangLuong.Thue) + BangLuong.Thuong + 
												(select pc.SoTienPhuCap  from inserted i join LuongPhuCap lpc on i.NhanVien = lpc.NhanVien join PhuCap pc
												on lpc.MaPhuCap = pc.MaPhuCap
												where BangLuong.HopDongLaoDong = i.HopDongLaoDong)
			
		
	end
go

-- Câu 23 : test ok

IF OBJECT_ID(N'CapNhat_SoTienGiamThucTe') IS NOT NULL
	DROP TRIGGER CapNhat_SoTienGiamThucTe
GO

Create TRIGGER CapNhat_SoTienGiamThucTe ON GioHang AFTER INSERT, UPDATE
AS
	BEGIN
		IF (UPDATE(TongTienChuaKhuyenMai))
			BEGIN
				DECLARE @TongTien BIGINT
				DECLARE @Voucher BIGINT
				DECLARE @SoTienGiam BIGINT
				DECLARE @GiamToiDa BIGINT
				DECLARE @PhanTram FLOAT
				DECLARE @ToiThieu BIGINT
				DECLARE @GioHang BIGINT
				SET @PhanTram = 0
				SET @SoTienGiam = 0
				
				SELECT @TongTien = i.TongTienChuaKhuyenMai , @Voucher = i.MaVoucher, @GioHang = i.MaGioHang FROM inserted i
				SELECT @PhanTram = v.PhanTramKhuyenMai, @GiamToiDa = v.SoTienGiamToiDa, @ToiThieu = v.GiaTriDonHangToiThieu FROM Voucher v WHERE v.MaVoucher = @Voucher
				print @PhanTram
				print @TongTien
				print @ToiThieu
				IF @TongTien < @ToiThieu
					BEGIN
						UPDATE GioHang SET SoTienGiamThucTe = 0 WHERE MaGioHang = @GioHang
					END
				ELSE 
					BEGIN
						IF @PhanTram IS NULL
							BEGIN
								UPDATE GioHang SET SoTienGiamThucTe = @GiamToiDa WHERE MaGioHang = @GioHang
							END
						ELSE
							BEGIN
								IF @PhanTram * @TongTien > @GiamToiDa
									BEGIN
										UPDATE GioHang SET SoTienGiamThucTe = @GiamToiDa WHERE MaGioHang = @GioHang
									END
								ELSE
									BEGIN
										UPDATE GioHang SET SoTienGiamThucTe = CAST(@PhanTram * @TongTien AS BIGINT) WHERE MaGioHang = @GioHang
									END
							END
					END

			END
	END
GO

Select * from GioHang
update GioHang set TongTienChuaKhuyenMai = 350 where MaVoucher = 1
Select * from GioHang


SELECT v.PhanTramKhuyenMai, v.SoTienGiamToiDa, v.GiaTriDonHangToiThieu FROM Voucher v WHERE v.MaVoucher = 1