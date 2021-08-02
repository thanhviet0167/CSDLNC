Use  NacoTikiDB
go

-- Cau 1

IF OBJECT_ID(N'KT_NgayTheoDoi') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
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
					print (N'Ngày theo dõi phải sau ngày tham gia');
					rollback transaction
				end

		end
go

-- Cau 2

IF OBJECT_ID(N'KT_NgayThanhToan') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_NgayThanhToan on ThongTinThanhToan for insert, update
as
	begin

		if(update(NgayHetHan))
			begin
				declare @c int;
				select @c = count(*) from inserted i join GiaoDich gd on i.TaiKhoanThanhToan = gd.TaiKhoanThanhToan
					where i.NgayHetHan < gd.NgayThanhToan
					if(@c > 0)
					begin
						print (N'Ngày hết hạn phải sau ngày thanh toán');
						rollback transaction
					end
			end
	end

	go

-- Câu 3
IF OBJECT_ID(N'KT_NgayDat_ThanhToan') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
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

-- Câu 4

IF OBJECT_ID(N'KT_NgayDanhGia') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_NgayDanhGia on ChiTietGioHang for update
as
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
go


-- Câu 5

IF OBJECT_ID(N'KT_TTDaGiao_KhieuNai') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_TTDaGiao_KhieuNai on KhieuNaiDonHang for insert
as
	begin
		if(exists(select * from inserted i join ThongTinVanChuyen ttvc on i.DonHang = ttvc.DonHang 
			where ttvc.TrangThaiVanChuyen != N'Đã giao'))
				begin
					print (N'Đơn khiếu nại phải được tạo sau khi đã giao hàng');
					rollback transaction
				end
	end
go

-- Câu 6

IF OBJECT_ID(N'KT_NgayKhieuNai') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_NgayKhieuNai on KhieuNaiDonHang for insert
as
	begin
		if(exists(select * from inserted i join ThongTinVanChuyen ttvc on i.DonHang = ttvc.DonHang
		where MONTH(i.NgayTaoKhieuNai) = MONTH(GETDATE())    
			and YEAR(i.NgayTaoKhieuNai) = YEAR(GETDATE()) and (DAY(i.NgayTaoKhieuNai) - DAY(GETDATE()) != 0  or 
			DAY(i.NgayTaoKhieuNai) - DAY(ttvc.ThoiGianVanChuyen) > 7)
		))
			begin
				print (N'Đơn khiếu nại phải được tạo sau khi đã giao hàng');
				rollback transaction
			end
	end
go

-- Câu 7

IF OBJECT_ID(N'KT_NgayThanhToan_GiaoDich') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_NgayThanhToan_GiaoDich on ThongTinVanChuyen for update
as
	begin
		if(update(ThoiGianVanChuyen))
			if(exists(select * from inserted i join DonHang dh on i.DonHang = dh.MaDonHang join GioHang gh 
			on dh.GioHang = gh.MaGioHang join GiaoDich gd on gh.KhachHang = gd.KhachHang where i.ThoiGianVanChuyen < gd.NgayThanhToan 
			and i.TrangThaiVanChuyen = N'Đã giao'))
			begin
				print (N'Ngày thanh toán phải trước ngày giao hàng');
				rollback transaction
			end
	end

go

-- Câu 8

IF OBJECT_ID(N'KT_SLTon') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
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
				print (N'Số lượng mua phải ít hơn số lượng tồn kho của sản phẩm');
				rollback transaction
			end

	end
go


-- Câu 9

IF OBJECT_ID(N'KT_SLQuaTangKem') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_SLQuaTangKem on ChiTietQuaTang for insert, update
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


-- Câu 10

IF OBJECT_ID(N'KT_GiaBanTangKem_CTQT') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_GiaBanTangKem_CTQT on ChiTietVoucher after insert, update
as
	begin
		if(update(PhanTramGiamGia) or update(SoLuongApDungToiDa))
			
			update ChiTietQuaTang set GiaBanTangKem = 
			(select sum ((1-i.PhanTramGiamGia)*sp.GiaHienHanh) from inserted i join ChiTietQuaTang ctqt on i.MaVoucher = ctqt.MaVoucher
			join ChiTietGioHang ctgh on ctqt.MaGioHang = ctgh.MaGioHang join SanPham sp on sp.MaSanPham = ctgh.MaSanPham)
	end
go

-- Câu 11 sửa mục phạm vi vận chuyển thành kiểu dữ liệu tinyint

IF OBJECT_ID(N'KT_PhiVanChuyen') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_PhiVanChuyen on ThongTinHinhThucVanChuyen for insert, update
as
	begin
		if(update(PhiGiaoHang))
			if(exists(
				select * from inserted i join HinhThucVanChuyen htvc on i.MaHinhThucVanChuyen = htvc.MaHinhThucVanChuyen
				where i.PhamViVanChuyen = N'Nội tỉnh' and i.PhiGiaoHang > (Select 
					ThongTinHinhThucVanChuyen.PhiGiaoHang from ThongTinHinhThucVanChuyen 
					where ThongTinHinhThucVanChuyen.MaHinhThucVanChuyen != i.MaHinhThucVanChuyen
					and ThongTinHinhThucVanChuyen.PhamViVanChuyen = 'Ngoại tỉnh')
			))
				begin
					print(N'Phí giao hàng ngoại tỉnh phải lớn hơn nội tỉnh')
					rollback tran
				end
	end
go

-- Câu 12

IF OBJECT_ID(N'KT_TongTienChuaKM') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO


Create trigger KT_TongTienChuaKM on GioHang for insert, update
as
	begin
		if(update(TongTienChuaKhuyenMai))
			if(exists( select * from inserted i join ChiTietGioHang ctgh on i.MaGioHang = ctgh.MaGioHang join 
			ChiTietQuaTang ctqt on ctgh.MaGioHang = ctqt.MaGioHang
			where i.TongTienChuaKhuyenMai != (ctgh.SoLuongMua*ctgh.GiaBanThucTe) + (ctqt.SoLuongTangKem*ctqt.GiaBanTangKem)
				
			))
				begin
					print(N'Tổng tiền chưa khuyến mãi không hợp lệ')
					rollback tran
				end
	end

go

-- Câu 13


IF OBJECT_ID(N'KT_ThanhTien_DonHang') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_ThanhTien_DonHang on GioHang after insert, update
as
	begin
		if(update(TongTienChuaKhuyenMai) or update(SoTienGiamThucTe))
			update DonHang set ThanhTien = (select gh.TongTienChuaKhuyenMai from inserted i join GioHang gh on i.MaGioHang = gh.MaGioHang)
			- (select gh.SoTienGiamThucTe from inserted i join GioHang gh on i.MaGioHang = gh.MaGioHang)
	end
go

-- Câu 14

IF OBJECT_ID(N'KT_TongTienGiaoDich') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
GO

Create trigger KT_TongTienGiaoDich on DonHang after insert, update
as
	begin
		if(update(ThanhTien) or update(PhiVanChuyen))
			update GiaoDich set TongTien = 
			(select sum(i.ThanhTien - i.PhiVanChuyen) from inserted i join GiaoDich gd on i.MaGiaoDich = gd.MaGiaoDich)
		
	end
go


-- Câu 15

IF OBJECT_ID(N'KT_BangLuong') IS NOT NULL
	DROP TRIGGER HoaDon_TongTien
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


