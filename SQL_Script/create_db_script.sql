USE [master]
GO
/****** Object:  Database [NacoTikiDB]    Script Date: 8/11/2021 8:32:09 PM ******/
CREATE DATABASE [NacoTikiDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'NacoTikiDB', FILENAME = N'D:\NacoTikiDB.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'NacoTikiDB_log', FILENAME = N'D:\NacoTikiDB_log.ldf' , SIZE = 401408KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [NacoTikiDB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [NacoTikiDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [NacoTikiDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [NacoTikiDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [NacoTikiDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [NacoTikiDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [NacoTikiDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [NacoTikiDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [NacoTikiDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [NacoTikiDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [NacoTikiDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [NacoTikiDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [NacoTikiDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [NacoTikiDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [NacoTikiDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [NacoTikiDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [NacoTikiDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [NacoTikiDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [NacoTikiDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [NacoTikiDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [NacoTikiDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [NacoTikiDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [NacoTikiDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [NacoTikiDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [NacoTikiDB] SET RECOVERY FULL 
GO
ALTER DATABASE [NacoTikiDB] SET  MULTI_USER 
GO
ALTER DATABASE [NacoTikiDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [NacoTikiDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [NacoTikiDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [NacoTikiDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [NacoTikiDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [NacoTikiDB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'NacoTikiDB', N'ON'
GO
ALTER DATABASE [NacoTikiDB] SET QUERY_STORE = OFF
GO
USE [NacoTikiDB]
GO
/****** Object:  Table [dbo].[BangLuong]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuong](
	[ThangKyLuong] [tinyint] NOT NULL,
	[NamKyLuong] [smallint] NOT NULL,
	[NhanVien] [bigint] NOT NULL,
	[SoNgayCong] [tinyint] NOT NULL,
	[LuongMotNgayCong] [bigint] NULL,
	[Thue] [float] NOT NULL,
	[Thuong] [bigint] NULL,
	[BaoHiemXaHoi] [float] NULL,
	[HopDongLaoDong] [bigint] NOT NULL,
	[NgayTaoBangLuong] [datetime] NOT NULL,
	[LuongThucNhan] [bigint] NOT NULL,
 CONSTRAINT [PK_BangLuong] PRIMARY KEY CLUSTERED 
(
	[ThangKyLuong] ASC,
	[NamKyLuong] ASC,
	[NhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BoSuuTap]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BoSuuTap](
	[Username] [varchar](20) NOT NULL,
	[STT] [tinyint] NOT NULL,
	[TenBoSuuTap] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_BoSuuTap] PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[STT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChamCong]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChamCong](
	[MaNhanVien] [bigint] IDENTITY(1,1) NOT NULL,
	[ThoiGianDiemDanh] [datetime] NOT NULL,
 CONSTRAINT [PK_ChamCong] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC,
	[ThoiGianDiemDanh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietGioHang]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietGioHang](
	[MaGioHang] [bigint] NOT NULL,
	[MaSanPham] [bigint] NOT NULL,
	[SoLuongMua] [smallint] NOT NULL,
	[GiaBanThucTe] [bigint] NOT NULL,
	[GiaGiam] [bigint] NULL,
	[DanhGia] [tinyint] NULL,
	[BinhLuan] [nvarchar](500) NULL,
	[ThoiGianDanhGia] [datetime] NULL,
 CONSTRAINT [PK_ChiTietGioHang] PRIMARY KEY CLUSTERED 
(
	[MaGioHang] ASC,
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietQuaTang]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietQuaTang](
	[MaVoucher] [bigint] NOT NULL,
	[MaGioHang] [bigint] NOT NULL,
	[SanPhamTangKem] [bigint] NOT NULL,
	[GiaBanTangKem] [bigint] NULL,
	[SoLuongTangKem] [smallint] NULL,
 CONSTRAINT [PK_ChiTietQuaTang] PRIMARY KEY CLUSTERED 
(
	[MaVoucher] ASC,
	[MaGioHang] ASC,
	[SanPhamTangKem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietVoucher]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietVoucher](
	[MaVoucher] [bigint] NOT NULL,
	[SanPhamTangKem] [bigint] NOT NULL,
	[PhanTramGiamGia] [float] NOT NULL,
	[SoLuongApDungToiDa] [smallint] NOT NULL,
 CONSTRAINT [PK_ChiTietVoucher] PRIMARY KEY CLUSTERED 
(
	[MaVoucher] ASC,
	[SanPhamTangKem] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[MaDanhMuc] [bigint] IDENTITY(1,1) NOT NULL,
	[TenDanhMuc] [nvarchar](50) NOT NULL,
	[MoTa] [ntext] NULL,
 CONSTRAINT [PK_DanhMuc] PRIMARY KEY CLUSTERED 
(
	[MaDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucSanPham]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucSanPham](
	[MaDanhMucSanPham] [bigint] IDENTITY(1,1) NOT NULL,
	[TenDanhMucSanPham] [nvarchar](50) NOT NULL,
	[MoTa] [ntext] NULL,
	[DanhMuc] [bigint] NOT NULL,
 CONSTRAINT [PK_DanhMucSanPham] PRIMARY KEY CLUSTERED 
(
	[MaDanhMucSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[MaDonHang] [bigint] IDENTITY(1,1) NOT NULL,
	[TrangThaiThanhToan] [bit] NOT NULL,
	[NgayDat] [datetime] NOT NULL,
	[ThanhTien] [bigint] NOT NULL,
	[GioHang] [bigint] NOT NULL,
	[MaGiaoDich] [bigint] NULL,
	[HinhThucVanChuyen] [bigint] NOT NULL,
	[PhiVanChuyen] [bigint] NOT NULL,
 CONSTRAINT [PK_DonHang] PRIMARY KEY CLUSTERED 
(
	[MaDonHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EmailDoanhNghiep]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmailDoanhNghiep](
	[MaNhanVien] [bigint] NOT NULL,
	[EmailDoanhNghiep] [varchar](50) NOT NULL,
 CONSTRAINT [PK_EmailDoanhNghiep] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiaoDich]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaoDich](
	[MaGiaoDich] [bigint] IDENTITY(1,1) NOT NULL,
	[TongTien] [bigint] NOT NULL,
	[TrangThaiThanhToan] [bit] NOT NULL,
	[KhachHang] [varchar](20) NOT NULL,
	[TaiKhoanThanhToan] [varchar](30) NOT NULL,
	[CongThanhToan] [varchar](30) NOT NULL,
	[NgayThanhToan] [datetime] NOT NULL,
 CONSTRAINT [PK_GiaoDich] PRIMARY KEY CLUSTERED 
(
	[MaGiaoDich] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHang]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHang](
	[MaGioHang] [bigint] IDENTITY(1,1) NOT NULL,
	[KhachHang] [varchar](20) NOT NULL,
	[NhaCungCap] [varchar](20) NOT NULL,
	[TongTienChuaKhuyenMai] [bigint] NOT NULL,
	[TongTienQuaTang] [bigint] NOT NULL,
	[TrangThaiDatHang] [bit] NOT NULL,
	[MaVoucher] [bigint] NULL,
	[SoTienGiamThucTe] [bigint] NOT NULL,
	[STT_SoDiaChi] [tinyint] NULL,
 CONSTRAINT [PK_GioHang] PRIMARY KEY CLUSTERED 
(
	[MaGioHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucVanChuyen]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucVanChuyen](
	[MaHinhThucVanChuyen] [bigint] IDENTITY(1,1) NOT NULL,
	[TenHinhThucVanChuyen] [nvarchar](50) NULL,
 CONSTRAINT [PK_HinhThucVanChuyen] PRIMARY KEY CLUSTERED 
(
	[MaHinhThucVanChuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDong](
	[MaHopDong] [bigint] NOT NULL,
	[NgayBatDau] [datetime] NOT NULL,
	[NgayKetThuc] [datetime] NOT NULL,
	[LuongThangThoaThuan] [bigint] NOT NULL,
	[SoNgayCongThangThoaThuan] [tinyint] NOT NULL,
	[MaNhanVien] [bigint] NOT NULL,
 CONSTRAINT [PK_HopDong] PRIMARY KEY CLUSTERED 
(
	[MaHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[Username] [varchar](20) NOT NULL,
	[Password] [varchar](20) NOT NULL,
	[HoTenKhachHang] [nvarchar](100) NULL,
	[Email] [varchar](50) NULL,
	[GioiTinh] [tinyint] NULL,
	[NgaySinh] [datetime] NULL,
	[AnhDaiDien] [varchar](100) NULL,
	[SDT_DangKy] [varchar](11) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhieuNaiDonHang]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhieuNaiDonHang](
	[DonHang] [bigint] NOT NULL,
	[STT_KhieuNai] [tinyint] NOT NULL,
	[NhanVienXuLy] [bigint] NULL,
	[NgayTaoKhieuNai] [datetime] NOT NULL,
	[NoiDungKhieuNai] [nvarchar](500) NOT NULL,
	[TrangThaiXuLy] [tinyint] NOT NULL,
	[MucDoHaiLongKhachHang] [tinyint] NULL,
 CONSTRAINT [PK_KhieuNaiDonHang] PRIMARY KEY CLUSTERED 
(
	[DonHang] ASC,
	[STT_KhieuNai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KyLuong]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KyLuong](
	[ThangKyLuong] [tinyint] NOT NULL,
	[NamKyLuong] [smallint] NOT NULL,
	[NgayChuyenLuong] [datetime] NULL,
	[TinhTrangChuyenLuong] [bit] NULL,
 CONSTRAINT [PK_KyLuong] PRIMARY KEY CLUSTERED 
(
	[ThangKyLuong] ASC,
	[NamKyLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LuongPhuCap]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LuongPhuCap](
	[MaPhuCap] [bigint] NOT NULL,
	[ThangKyLuong] [tinyint] NOT NULL,
	[NamKyLuong] [smallint] NOT NULL,
	[NhanVien] [bigint] NOT NULL,
 CONSTRAINT [PK_LuongPhuCap] PRIMARY KEY CLUSTERED 
(
	[MaPhuCap] ASC,
	[ThangKyLuong] ASC,
	[NamKyLuong] ASC,
	[NhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[Username] [varchar](20) NOT NULL,
	[TenNhaCungCap] [nvarchar](100) NOT NULL,
	[MoTa] [nvarchar](300) NULL,
	[NgayThamGia] [datetime] NOT NULL,
	[SDT_LienLac] [varchar](11) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[MaTinhThanhPho] [tinyint] NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [bigint] IDENTITY(1,1) NOT NULL,
	[HoTenNhanVien] [nvarchar](100) NOT NULL,
	[NgaySinh] [datetime] NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[EmailCaNhan] [varchar](50) NULL,
	[LoaiNhanVien] [tinyint] NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuCap]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuCap](
	[MaPhuCap] [bigint] NOT NULL,
	[NoiDungPhuCap] [nvarchar](50) NULL,
	[SoTienPhuCap] [bigint] NULL,
 CONSTRAINT [PK_PhuCap] PRIMARY KEY CLUSTERED 
(
	[MaPhuCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhuongThucThanhToan]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhuongThucThanhToan](
	[Username] [varchar](20) NOT NULL,
	[TaiKhoanThanhToan] [varchar](30) NOT NULL,
	[CongThanhToan] [varchar](30) NOT NULL,
	[TinhTrangXacThuc] [bit] NOT NULL,
 CONSTRAINT [PK_PhuongThucThanhToan] PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[TaiKhoanThanhToan] ASC,
	[CongThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [bigint] IDENTITY(1,1) NOT NULL,
	[TenSanPham] [nvarchar](50) NOT NULL,
	[HinhAnh] [varchar](100) NULL,
	[XuatXu] [nvarchar](50) NULL,
	[MoTa] [ntext] NULL,
	[GiaHienHanh] [bigint] NOT NULL,
	[SoLuongTon] [smallint] NOT NULL,
	[GiaSi] [bigint] NULL,
	[SoLuongSi] [smallint] NULL,
	[GiaGiam] [bigint] NULL,
	[SoLuongGiamGia] [smallint] NULL,
	[DanhMucSanPham] [bigint] NULL,
	[NhaCungCap] [varchar](20) NOT NULL,
	[STT_BoSuuTap] [tinyint] NULL,
	[NgayTaoSanPham] [datetime] NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPhamYeuThich]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPhamYeuThich](
	[SanPham] [bigint] NOT NULL,
	[KhachHang] [varchar](20) NOT NULL,
	[ThoiGian] [datetime] NOT NULL,
 CONSTRAINT [PK_SanPhamYeuThich] PRIMARY KEY CLUSTERED 
(
	[SanPham] ASC,
	[KhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SoDiaChi]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SoDiaChi](
	[Username] [varchar](20) NOT NULL,
	[STT] [tinyint] NOT NULL,
	[HoTenNguoiNhan] [nvarchar](50) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[MaTinhThanhPho] [tinyint] NOT NULL,
	[SDT] [varchar](11) NOT NULL,
 CONSTRAINT [PK_SoDiaChi] PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[STT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheoDoiNhaCungCap]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheoDoiNhaCungCap](
	[MaKhachHang] [varchar](20) NOT NULL,
	[MaNhaCungCap] [varchar](20) NOT NULL,
	[NgayTheoDoi] [datetime] NOT NULL,
 CONSTRAINT [PK_TheoDoiNhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC,
	[MaNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinCongThanhToan]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinCongThanhToan](
	[MaCongThanhToan] [varchar](30) NOT NULL,
	[TenCongThanhToan] [nvarchar](100) NULL,
 CONSTRAINT [PK_ThongTinCongThanhToan] PRIMARY KEY CLUSTERED 
(
	[MaCongThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinHinhThucVanChuyen]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinHinhThucVanChuyen](
	[MaHinhThucVanChuyen] [bigint] IDENTITY(1,1) NOT NULL,
	[PhamViVanChuyen] [tinyint] NOT NULL,
	[PhiGiaoHang] [bigint] NOT NULL,
	[ThoiGianGiaoHang] [tinyint] NOT NULL,
 CONSTRAINT [PK_ThongTinHinhThucVanChuyen] PRIMARY KEY CLUSTERED 
(
	[MaHinhThucVanChuyen] ASC,
	[PhamViVanChuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinThanhToan]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinThanhToan](
	[TaiKhoanThanhToan] [varchar](30) NOT NULL,
	[CongThanhToan] [varchar](30) NOT NULL,
	[LoaiPhuongThucThanhToan] [tinyint] NOT NULL,
	[HoTenChuTaiKhoan] [varchar](50) NOT NULL,
	[ChiNhanh] [nvarchar](100) NULL,
	[LoaiThe] [varchar](50) NULL,
	[NgayHetHan] [datetime] NOT NULL,
 CONSTRAINT [PK_ThongTinThanhToan] PRIMARY KEY CLUSTERED 
(
	[TaiKhoanThanhToan] ASC,
	[CongThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinVanChuyen]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinVanChuyen](
	[NhanVienGiaoHang] [bigint] NOT NULL,
	[DonHang] [bigint] NOT NULL,
	[TrangThaiVanChuyen] [nvarchar](200) NULL,
	[ThoiGianVanChuyen] [datetime] NULL,
 CONSTRAINT [PK_ThongTinVanChuyen] PRIMARY KEY CLUSTERED 
(
	[NhanVienGiaoHang] ASC,
	[DonHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TinhThanhPho]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TinhThanhPho](
	[MaTinhThanhPho] [tinyint] NOT NULL,
	[TenTinhThanhPho] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_TinhThanhPho] PRIMARY KEY CLUSTERED 
(
	[MaTinhThanhPho] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[MaVoucher] [bigint] IDENTITY(1,1) NOT NULL,
	[SoLuongVoucher] [smallint] NOT NULL,
	[NgayBatDau] [datetime] NOT NULL,
	[NgayKetThuc] [datetime] NOT NULL,
	[LoaiVoucher] [tinyint] NOT NULL,
	[GiaTriDonHangToiThieu] [bigint] NULL,
	[PhanTramKhuyenMai] [float] NULL,
	[SoTienGiamToiDa] [bigint] NULL,
	[SanPhamApDung] [bigint] NULL,
	[NhaCungCap] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Voucher] PRIMARY KEY CLUSTERED 
(
	[MaVoucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VoucherApDung]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VoucherApDung](
	[MaVoucher] [bigint] NOT NULL,
	[MaGioHang] [bigint] NOT NULL,
 CONSTRAINT [PK_VoucherApDung] PRIMARY KEY CLUSTERED 
(
	[MaVoucher] ASC,
	[MaGioHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XemSanPham]    Script Date: 8/11/2021 8:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XemSanPham](
	[SanPham] [bigint] NOT NULL,
	[KhachHang] [varchar](20) NOT NULL,
	[ThoiGian] [datetime] NOT NULL,
 CONSTRAINT [PK_XemSanPham] PRIMARY KEY CLUSTERED 
(
	[SanPham] ASC,
	[KhachHang] ASC,
	[ThoiGian] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[BangLuong] ADD  CONSTRAINT [DF_BangLuong_SoNgayCong]  DEFAULT ((0)) FOR [SoNgayCong]
GO
ALTER TABLE [dbo].[BangLuong] ADD  CONSTRAINT [DF_BangLuong_LuongMotNgayCong]  DEFAULT ((0)) FOR [LuongMotNgayCong]
GO
ALTER TABLE [dbo].[BangLuong] ADD  CONSTRAINT [DF_BangLuong_Thue]  DEFAULT ((0)) FOR [Thue]
GO
ALTER TABLE [dbo].[BangLuong] ADD  CONSTRAINT [DF_BangLuong_Thuong]  DEFAULT ((0)) FOR [Thuong]
GO
ALTER TABLE [dbo].[BangLuong] ADD  CONSTRAINT [DF_BangLuong_BaoHiemXaHoi]  DEFAULT ((0)) FOR [BaoHiemXaHoi]
GO
ALTER TABLE [dbo].[BangLuong] ADD  CONSTRAINT [DF_BangLuong_LuongThucNhan]  DEFAULT ((0)) FOR [LuongThucNhan]
GO
ALTER TABLE [dbo].[ChamCong] ADD  CONSTRAINT [DF_ChamCong_ThoiGianDiemDanh]  DEFAULT (getdate()) FOR [ThoiGianDiemDanh]
GO
ALTER TABLE [dbo].[ChiTietGioHang] ADD  CONSTRAINT [DF_ChiTietGioHang_SoLuongMua]  DEFAULT ((1)) FOR [SoLuongMua]
GO
ALTER TABLE [dbo].[ChiTietGioHang] ADD  CONSTRAINT [DF_ChiTietGioHang_GiaBanThucTe]  DEFAULT ((0)) FOR [GiaBanThucTe]
GO
ALTER TABLE [dbo].[ChiTietGioHang] ADD  CONSTRAINT [DF_ChiTietGioHang_GiaGiam]  DEFAULT ((0)) FOR [GiaGiam]
GO
ALTER TABLE [dbo].[ChiTietQuaTang] ADD  CONSTRAINT [DF_ChiTietQuaTang_GiaBanTangKem]  DEFAULT ((0)) FOR [GiaBanTangKem]
GO
ALTER TABLE [dbo].[ChiTietQuaTang] ADD  CONSTRAINT [DF_ChiTietQuaTang_SoLuongTangKem]  DEFAULT ((0)) FOR [SoLuongTangKem]
GO
ALTER TABLE [dbo].[ChiTietVoucher] ADD  CONSTRAINT [DF_ChiTietVoucher_PhanTramGiamGia]  DEFAULT ((0)) FOR [PhanTramGiamGia]
GO
ALTER TABLE [dbo].[ChiTietVoucher] ADD  CONSTRAINT [DF_ChiTietVoucher_SoLuongApDungToiDa]  DEFAULT ((0)) FOR [SoLuongApDungToiDa]
GO
ALTER TABLE [dbo].[DonHang] ADD  CONSTRAINT [DF_DonHang_ThanhTien]  DEFAULT ((0)) FOR [ThanhTien]
GO
ALTER TABLE [dbo].[DonHang] ADD  CONSTRAINT [DF_DonHang_PhiVanChuyen]  DEFAULT ((0)) FOR [PhiVanChuyen]
GO
ALTER TABLE [dbo].[GiaoDich] ADD  CONSTRAINT [DF_GiaoDich_TongTien]  DEFAULT ((0)) FOR [TongTien]
GO
ALTER TABLE [dbo].[GiaoDich] ADD  CONSTRAINT [DF_GiaoDich_TrangThaiThanhToan]  DEFAULT ((0)) FOR [TrangThaiThanhToan]
GO
ALTER TABLE [dbo].[GioHang] ADD  CONSTRAINT [DF_GioHang_TongTienChuaKhuyenMai]  DEFAULT ((0)) FOR [TongTienChuaKhuyenMai]
GO
ALTER TABLE [dbo].[GioHang] ADD  CONSTRAINT [DF_GioHang_TongTienQuaTang]  DEFAULT ((0)) FOR [TongTienQuaTang]
GO
ALTER TABLE [dbo].[GioHang] ADD  CONSTRAINT [DF_GioHang_TrangThaiDatHang]  DEFAULT ((0)) FOR [TrangThaiDatHang]
GO
ALTER TABLE [dbo].[GioHang] ADD  CONSTRAINT [DF_GioHang_SoTienGiamThucTe]  DEFAULT ((0)) FOR [SoTienGiamThucTe]
GO
ALTER TABLE [dbo].[HopDong] ADD  CONSTRAINT [DF_HopDong_LuongThangThoaThuan]  DEFAULT ((0)) FOR [LuongThangThoaThuan]
GO
ALTER TABLE [dbo].[HopDong] ADD  CONSTRAINT [DF_HopDong_SoNgayCongThangThoaThuan]  DEFAULT ((7)) FOR [SoNgayCongThangThoaThuan]
GO
ALTER TABLE [dbo].[KhieuNaiDonHang] ADD  CONSTRAINT [DF_KhieuNaiDonHang_TrangThaiXuLy]  DEFAULT ((0)) FOR [TrangThaiXuLy]
GO
ALTER TABLE [dbo].[KhieuNaiDonHang] ADD  CONSTRAINT [DF_KhieuNaiDonHang_MucDoHaiLongKhachHang]  DEFAULT ((0)) FOR [MucDoHaiLongKhachHang]
GO
ALTER TABLE [dbo].[KyLuong] ADD  CONSTRAINT [DF_KyLuong_TinhTrangChuyenLuong]  DEFAULT ((0)) FOR [TinhTrangChuyenLuong]
GO
ALTER TABLE [dbo].[PhuongThucThanhToan] ADD  CONSTRAINT [DF_PhuongThucThanhToan_TinhTrangXacThuc]  DEFAULT ((0)) FOR [TinhTrangXacThuc]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_GiaHienHanh]  DEFAULT ((0)) FOR [GiaHienHanh]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_SoLuongTon]  DEFAULT ((0)) FOR [SoLuongTon]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_NgayTaoSanPham]  DEFAULT (getdate()) FOR [NgayTaoSanPham]
GO
ALTER TABLE [dbo].[SanPhamYeuThich] ADD  CONSTRAINT [DF_SanPhamYeuThich_ThoiGian]  DEFAULT (getdate()) FOR [ThoiGian]
GO
ALTER TABLE [dbo].[TheoDoiNhaCungCap] ADD  CONSTRAINT [DF_TheoDoiNhaCungCap_NgayTheoDoi]  DEFAULT (getdate()) FOR [NgayTheoDoi]
GO
ALTER TABLE [dbo].[Voucher] ADD  CONSTRAINT [DF_Voucher_GiaTriDonHangToiThieu]  DEFAULT ((0)) FOR [GiaTriDonHangToiThieu]
GO
ALTER TABLE [dbo].[XemSanPham] ADD  CONSTRAINT [DF_XemSanPham_ThoiGian]  DEFAULT (getdate()) FOR [ThoiGian]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [FK_BangLuong_HopDong] FOREIGN KEY([HopDongLaoDong])
REFERENCES [dbo].[HopDong] ([MaHopDong])
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [FK_BangLuong_HopDong]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [FK_BangLuong_KyLuong] FOREIGN KEY([ThangKyLuong], [NamKyLuong])
REFERENCES [dbo].[KyLuong] ([ThangKyLuong], [NamKyLuong])
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [FK_BangLuong_KyLuong]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [FK_BangLuong_NhanVien] FOREIGN KEY([NhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [FK_BangLuong_NhanVien]
GO
ALTER TABLE [dbo].[BoSuuTap]  WITH CHECK ADD  CONSTRAINT [FK_BoSuuTap_NhaCungCap] FOREIGN KEY([Username])
REFERENCES [dbo].[NhaCungCap] ([Username])
GO
ALTER TABLE [dbo].[BoSuuTap] CHECK CONSTRAINT [FK_BoSuuTap_NhaCungCap]
GO
ALTER TABLE [dbo].[ChamCong]  WITH CHECK ADD  CONSTRAINT [FK_ChamCong_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[ChamCong] CHECK CONSTRAINT [FK_ChamCong_NhanVien]
GO
ALTER TABLE [dbo].[ChiTietGioHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietGioHang_GioHang] FOREIGN KEY([MaGioHang])
REFERENCES [dbo].[GioHang] ([MaGioHang])
GO
ALTER TABLE [dbo].[ChiTietGioHang] CHECK CONSTRAINT [FK_ChiTietGioHang_GioHang]
GO
ALTER TABLE [dbo].[ChiTietGioHang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietGioHang_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTietGioHang] CHECK CONSTRAINT [FK_ChiTietGioHang_SanPham]
GO
ALTER TABLE [dbo].[ChiTietQuaTang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietQuaTang_SanPham] FOREIGN KEY([SanPhamTangKem])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTietQuaTang] CHECK CONSTRAINT [FK_ChiTietQuaTang_SanPham]
GO
ALTER TABLE [dbo].[ChiTietQuaTang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietQuaTang_Voucher] FOREIGN KEY([MaVoucher])
REFERENCES [dbo].[Voucher] ([MaVoucher])
GO
ALTER TABLE [dbo].[ChiTietQuaTang] CHECK CONSTRAINT [FK_ChiTietQuaTang_Voucher]
GO
ALTER TABLE [dbo].[ChiTietQuaTang]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietQuaTang_VoucherApDung1] FOREIGN KEY([MaVoucher], [MaGioHang])
REFERENCES [dbo].[VoucherApDung] ([MaVoucher], [MaGioHang])
GO
ALTER TABLE [dbo].[ChiTietQuaTang] CHECK CONSTRAINT [FK_ChiTietQuaTang_VoucherApDung1]
GO
ALTER TABLE [dbo].[ChiTietVoucher]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietVoucher_SanPham] FOREIGN KEY([SanPhamTangKem])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[ChiTietVoucher] CHECK CONSTRAINT [FK_ChiTietVoucher_SanPham]
GO
ALTER TABLE [dbo].[ChiTietVoucher]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietVoucher_Voucher] FOREIGN KEY([MaVoucher])
REFERENCES [dbo].[Voucher] ([MaVoucher])
GO
ALTER TABLE [dbo].[ChiTietVoucher] CHECK CONSTRAINT [FK_ChiTietVoucher_Voucher]
GO
ALTER TABLE [dbo].[DanhMucSanPham]  WITH CHECK ADD  CONSTRAINT [FK_DanhMucSanPham_DanhMuc] FOREIGN KEY([DanhMuc])
REFERENCES [dbo].[DanhMuc] ([MaDanhMuc])
GO
ALTER TABLE [dbo].[DanhMucSanPham] CHECK CONSTRAINT [FK_DanhMucSanPham_DanhMuc]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_GiaoDich] FOREIGN KEY([MaGiaoDich])
REFERENCES [dbo].[GiaoDich] ([MaGiaoDich])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_GiaoDich]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_GioHang] FOREIGN KEY([GioHang])
REFERENCES [dbo].[GioHang] ([MaGioHang])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_GioHang]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_HinhThucVanChuyen] FOREIGN KEY([HinhThucVanChuyen])
REFERENCES [dbo].[HinhThucVanChuyen] ([MaHinhThucVanChuyen])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_HinhThucVanChuyen]
GO
ALTER TABLE [dbo].[EmailDoanhNghiep]  WITH CHECK ADD  CONSTRAINT [FK_EmailDoanhNghiep_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[EmailDoanhNghiep] CHECK CONSTRAINT [FK_EmailDoanhNghiep_NhanVien]
GO
ALTER TABLE [dbo].[GiaoDich]  WITH CHECK ADD  CONSTRAINT [FK_GiaoDich_PhuongThucThanhToan] FOREIGN KEY([KhachHang], [TaiKhoanThanhToan], [CongThanhToan])
REFERENCES [dbo].[PhuongThucThanhToan] ([Username], [TaiKhoanThanhToan], [CongThanhToan])
GO
ALTER TABLE [dbo].[GiaoDich] CHECK CONSTRAINT [FK_GiaoDich_PhuongThucThanhToan]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [FK_GioHang_KhachHang] FOREIGN KEY([KhachHang])
REFERENCES [dbo].[KhachHang] ([Username])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [FK_GioHang_KhachHang]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [FK_GioHang_NhaCungCap] FOREIGN KEY([NhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([Username])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [FK_GioHang_NhaCungCap]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [FK_GioHang_SoDiaChi] FOREIGN KEY([KhachHang], [STT_SoDiaChi])
REFERENCES [dbo].[SoDiaChi] ([Username], [STT])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [FK_GioHang_SoDiaChi]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [FK_GioHang_Voucher] FOREIGN KEY([MaVoucher])
REFERENCES [dbo].[Voucher] ([MaVoucher])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [FK_GioHang_Voucher]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [FK_HopDong_NhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [FK_HopDong_NhanVien]
GO
ALTER TABLE [dbo].[KhieuNaiDonHang]  WITH CHECK ADD  CONSTRAINT [FK_KhieuNaiDonHang_DonHang] FOREIGN KEY([DonHang])
REFERENCES [dbo].[DonHang] ([MaDonHang])
GO
ALTER TABLE [dbo].[KhieuNaiDonHang] CHECK CONSTRAINT [FK_KhieuNaiDonHang_DonHang]
GO
ALTER TABLE [dbo].[KhieuNaiDonHang]  WITH CHECK ADD  CONSTRAINT [FK_KhieuNaiDonHang_NhanVien] FOREIGN KEY([NhanVienXuLy])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[KhieuNaiDonHang] CHECK CONSTRAINT [FK_KhieuNaiDonHang_NhanVien]
GO
ALTER TABLE [dbo].[LuongPhuCap]  WITH CHECK ADD  CONSTRAINT [FK_LuongPhuCap_BangLuong] FOREIGN KEY([ThangKyLuong], [NamKyLuong], [NhanVien])
REFERENCES [dbo].[BangLuong] ([ThangKyLuong], [NamKyLuong], [NhanVien])
GO
ALTER TABLE [dbo].[LuongPhuCap] CHECK CONSTRAINT [FK_LuongPhuCap_BangLuong]
GO
ALTER TABLE [dbo].[LuongPhuCap]  WITH CHECK ADD  CONSTRAINT [FK_LuongPhuCap_PhuCap] FOREIGN KEY([MaPhuCap])
REFERENCES [dbo].[PhuCap] ([MaPhuCap])
GO
ALTER TABLE [dbo].[LuongPhuCap] CHECK CONSTRAINT [FK_LuongPhuCap_PhuCap]
GO
ALTER TABLE [dbo].[NhaCungCap]  WITH CHECK ADD  CONSTRAINT [FK_NhaCungCap_KhachHang] FOREIGN KEY([Username])
REFERENCES [dbo].[KhachHang] ([Username])
GO
ALTER TABLE [dbo].[NhaCungCap] CHECK CONSTRAINT [FK_NhaCungCap_KhachHang]
GO
ALTER TABLE [dbo].[NhaCungCap]  WITH CHECK ADD  CONSTRAINT [FK_NhaCungCap_TinhThanhPho] FOREIGN KEY([MaTinhThanhPho])
REFERENCES [dbo].[TinhThanhPho] ([MaTinhThanhPho])
GO
ALTER TABLE [dbo].[NhaCungCap] CHECK CONSTRAINT [FK_NhaCungCap_TinhThanhPho]
GO
ALTER TABLE [dbo].[PhuongThucThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_PhuongThucThanhToan_KhachHang] FOREIGN KEY([Username])
REFERENCES [dbo].[KhachHang] ([Username])
GO
ALTER TABLE [dbo].[PhuongThucThanhToan] CHECK CONSTRAINT [FK_PhuongThucThanhToan_KhachHang]
GO
ALTER TABLE [dbo].[PhuongThucThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_PhuongThucThanhToan_ThongTinThanhToan1] FOREIGN KEY([TaiKhoanThanhToan], [CongThanhToan])
REFERENCES [dbo].[ThongTinThanhToan] ([TaiKhoanThanhToan], [CongThanhToan])
GO
ALTER TABLE [dbo].[PhuongThucThanhToan] CHECK CONSTRAINT [FK_PhuongThucThanhToan_ThongTinThanhToan1]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_BoSuuTap] FOREIGN KEY([NhaCungCap], [STT_BoSuuTap])
REFERENCES [dbo].[BoSuuTap] ([Username], [STT])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_BoSuuTap]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_DanhMucSanPham] FOREIGN KEY([DanhMucSanPham])
REFERENCES [dbo].[DanhMucSanPham] ([MaDanhMucSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_DanhMucSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([NhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([Username])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPhamYeuThich]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamYeuThich_KhachHang] FOREIGN KEY([KhachHang])
REFERENCES [dbo].[KhachHang] ([Username])
GO
ALTER TABLE [dbo].[SanPhamYeuThich] CHECK CONSTRAINT [FK_SanPhamYeuThich_KhachHang]
GO
ALTER TABLE [dbo].[SanPhamYeuThich]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamYeuThich_SanPham] FOREIGN KEY([SanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[SanPhamYeuThich] CHECK CONSTRAINT [FK_SanPhamYeuThich_SanPham]
GO
ALTER TABLE [dbo].[SoDiaChi]  WITH CHECK ADD  CONSTRAINT [FK_SoDiaChi_KhachHang] FOREIGN KEY([Username])
REFERENCES [dbo].[KhachHang] ([Username])
GO
ALTER TABLE [dbo].[SoDiaChi] CHECK CONSTRAINT [FK_SoDiaChi_KhachHang]
GO
ALTER TABLE [dbo].[SoDiaChi]  WITH CHECK ADD  CONSTRAINT [FK_SoDiaChi_TinhThanhPho] FOREIGN KEY([MaTinhThanhPho])
REFERENCES [dbo].[TinhThanhPho] ([MaTinhThanhPho])
GO
ALTER TABLE [dbo].[SoDiaChi] CHECK CONSTRAINT [FK_SoDiaChi_TinhThanhPho]
GO
ALTER TABLE [dbo].[TheoDoiNhaCungCap]  WITH CHECK ADD  CONSTRAINT [FK_TheoDoiNhaCungCap_KhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([Username])
GO
ALTER TABLE [dbo].[TheoDoiNhaCungCap] CHECK CONSTRAINT [FK_TheoDoiNhaCungCap_KhachHang]
GO
ALTER TABLE [dbo].[TheoDoiNhaCungCap]  WITH CHECK ADD  CONSTRAINT [FK_TheoDoiNhaCungCap_NhaCungCap] FOREIGN KEY([MaNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([Username])
GO
ALTER TABLE [dbo].[TheoDoiNhaCungCap] CHECK CONSTRAINT [FK_TheoDoiNhaCungCap_NhaCungCap]
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen]  WITH CHECK ADD  CONSTRAINT [FK_ThongTinHinhThucVanChuyen_HinhThucVanChuyen] FOREIGN KEY([MaHinhThucVanChuyen])
REFERENCES [dbo].[HinhThucVanChuyen] ([MaHinhThucVanChuyen])
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen] CHECK CONSTRAINT [FK_ThongTinHinhThucVanChuyen_HinhThucVanChuyen]
GO
ALTER TABLE [dbo].[ThongTinThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_ThongTinThanhToan_ThongTinCongThanhToan] FOREIGN KEY([CongThanhToan])
REFERENCES [dbo].[ThongTinCongThanhToan] ([MaCongThanhToan])
GO
ALTER TABLE [dbo].[ThongTinThanhToan] CHECK CONSTRAINT [FK_ThongTinThanhToan_ThongTinCongThanhToan]
GO
ALTER TABLE [dbo].[ThongTinVanChuyen]  WITH CHECK ADD  CONSTRAINT [FK_ThongTinVanChuyen_DonHang] FOREIGN KEY([DonHang])
REFERENCES [dbo].[DonHang] ([MaDonHang])
GO
ALTER TABLE [dbo].[ThongTinVanChuyen] CHECK CONSTRAINT [FK_ThongTinVanChuyen_DonHang]
GO
ALTER TABLE [dbo].[ThongTinVanChuyen]  WITH CHECK ADD  CONSTRAINT [FK_ThongTinVanChuyen_NhanVien] FOREIGN KEY([NhanVienGiaoHang])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[ThongTinVanChuyen] CHECK CONSTRAINT [FK_ThongTinVanChuyen_NhanVien]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [FK_Voucher_NhaCungCap] FOREIGN KEY([NhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([Username])
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [FK_Voucher_NhaCungCap]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [FK_Voucher_SanPham] FOREIGN KEY([SanPhamApDung])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [FK_Voucher_SanPham]
GO
ALTER TABLE [dbo].[VoucherApDung]  WITH CHECK ADD  CONSTRAINT [FK_VoucherApDung_GioHang] FOREIGN KEY([MaGioHang])
REFERENCES [dbo].[GioHang] ([MaGioHang])
GO
ALTER TABLE [dbo].[VoucherApDung] CHECK CONSTRAINT [FK_VoucherApDung_GioHang]
GO
ALTER TABLE [dbo].[XemSanPham]  WITH CHECK ADD  CONSTRAINT [FK_XemSanPham_KhachHang] FOREIGN KEY([KhachHang])
REFERENCES [dbo].[KhachHang] ([Username])
GO
ALTER TABLE [dbo].[XemSanPham] CHECK CONSTRAINT [FK_XemSanPham_KhachHang]
GO
ALTER TABLE [dbo].[XemSanPham]  WITH CHECK ADD  CONSTRAINT [FK_XemSanPham_SanPham] FOREIGN KEY([SanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[XemSanPham] CHECK CONSTRAINT [FK_XemSanPham_SanPham]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [CK_BangLuong_BHXH] CHECK  (([BaoHiemXaHoi]>=(0) AND [BaoHiemXaHoi]<=(100)))
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [CK_BangLuong_BHXH]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [CK_BangLuong_LuongTN] CHECK  (([LuongThucNhan]>=(0)))
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [CK_BangLuong_LuongTN]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [CK_BangLuong_Nam] CHECK  (([NamKyLuong]>=(1900) AND [NamKyLuong]<=datepart(year,getdate())))
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [CK_BangLuong_Nam]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [CK_BangLuong_NgayTao] CHECK  (([NgayTaoBangLuong]<=getdate()))
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [CK_BangLuong_NgayTao]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [CK_BangLuong_NhanVien] CHECK  (([NhanVien]>(0)))
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [CK_BangLuong_NhanVien]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [CK_BangLuong_Thang] CHECK  (([ThangKyLuong]>=(1) AND [ThangKyLuong]<=(12)))
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [CK_BangLuong_Thang]
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD  CONSTRAINT [CK_BangLuong_Thue] CHECK  (([Thue]>=(0) AND [Thue]<=(100)))
GO
ALTER TABLE [dbo].[BangLuong] CHECK CONSTRAINT [CK_BangLuong_Thue]
GO
ALTER TABLE [dbo].[BoSuuTap]  WITH CHECK ADD  CONSTRAINT [CK_BoSuuTap_STT] CHECK  (([STT]>(0)))
GO
ALTER TABLE [dbo].[BoSuuTap] CHECK CONSTRAINT [CK_BoSuuTap_STT]
GO
ALTER TABLE [dbo].[ChamCong]  WITH CHECK ADD  CONSTRAINT [CK_ChamCong_ID] CHECK  (([MaNhanVien]>(0)))
GO
ALTER TABLE [dbo].[ChamCong] CHECK CONSTRAINT [CK_ChamCong_ID]
GO
ALTER TABLE [dbo].[ChiTietGioHang]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietGioHang_GiaBan] CHECK  (([GiaBanThucTe]>=(0)))
GO
ALTER TABLE [dbo].[ChiTietGioHang] CHECK CONSTRAINT [CK_ChiTietGioHang_GiaBan]
GO
ALTER TABLE [dbo].[ChiTietGioHang]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietGioHang_GiaGiam] CHECK  (([GiaGiam]>=(0)))
GO
ALTER TABLE [dbo].[ChiTietGioHang] CHECK CONSTRAINT [CK_ChiTietGioHang_GiaGiam]
GO
ALTER TABLE [dbo].[ChiTietGioHang]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietGioHang_ID] CHECK  (([MaGioHang]>(0) AND [MaSanPham]>(0)))
GO
ALTER TABLE [dbo].[ChiTietGioHang] CHECK CONSTRAINT [CK_ChiTietGioHang_ID]
GO
ALTER TABLE [dbo].[ChiTietGioHang]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietGioHang_SoLuongMua] CHECK  (([SoLuongMua]>=(1)))
GO
ALTER TABLE [dbo].[ChiTietGioHang] CHECK CONSTRAINT [CK_ChiTietGioHang_SoLuongMua]
GO
ALTER TABLE [dbo].[ChiTietQuaTang]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietQuaTang_GiaBan] CHECK  (([GiaBanTangKem]>=(0)))
GO
ALTER TABLE [dbo].[ChiTietQuaTang] CHECK CONSTRAINT [CK_ChiTietQuaTang_GiaBan]
GO
ALTER TABLE [dbo].[ChiTietQuaTang]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietQuaTang_ID] CHECK  (([MaVoucher]>(0) AND [MaGioHang]>(0) AND [SanPhamTangKem]>(0)))
GO
ALTER TABLE [dbo].[ChiTietQuaTang] CHECK CONSTRAINT [CK_ChiTietQuaTang_ID]
GO
ALTER TABLE [dbo].[ChiTietQuaTang]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietQuaTang_SoLuong] CHECK  (([SoLuongTangKem]>(0)))
GO
ALTER TABLE [dbo].[ChiTietQuaTang] CHECK CONSTRAINT [CK_ChiTietQuaTang_SoLuong]
GO
ALTER TABLE [dbo].[ChiTietVoucher]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietVoucher_PhanTram] CHECK  (([PhanTramGiamGia]>=(0.05) AND [PhanTramGiamGia]<=(1)))
GO
ALTER TABLE [dbo].[ChiTietVoucher] CHECK CONSTRAINT [CK_ChiTietVoucher_PhanTram]
GO
ALTER TABLE [dbo].[ChiTietVoucher]  WITH CHECK ADD  CONSTRAINT [CK_ChiTietVoucher_SoLuongApDung] CHECK  (([SoLuongApDungToiDa]>(0)))
GO
ALTER TABLE [dbo].[ChiTietVoucher] CHECK CONSTRAINT [CK_ChiTietVoucher_SoLuongApDung]
GO
ALTER TABLE [dbo].[DanhMuc]  WITH CHECK ADD  CONSTRAINT [CK_DanhMuc_ID] CHECK  (([MaDanhMuc]>(0)))
GO
ALTER TABLE [dbo].[DanhMuc] CHECK CONSTRAINT [CK_DanhMuc_ID]
GO
ALTER TABLE [dbo].[DanhMucSanPham]  WITH CHECK ADD  CONSTRAINT [CK_DanhMucSanPham_ID] CHECK  (([MaDanhMucSanPham]>(0)))
GO
ALTER TABLE [dbo].[DanhMucSanPham] CHECK CONSTRAINT [CK_DanhMucSanPham_ID]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [CK_DonHang_ID] CHECK  (([MaDonHang]>(0)))
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [CK_DonHang_ID]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [CK_DonHang_PhiVC] CHECK  (([PhiVanChuyen]>=(0)))
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [CK_DonHang_PhiVC]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [CK_DonHang_ThanhTien] CHECK  (([ThanhTien]>=(0)))
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [CK_DonHang_ThanhTien]
GO
ALTER TABLE [dbo].[EmailDoanhNghiep]  WITH CHECK ADD  CONSTRAINT [CK_EmailDoanhNghiep_ID] CHECK  (([MaNhanVien]>(0)))
GO
ALTER TABLE [dbo].[EmailDoanhNghiep] CHECK CONSTRAINT [CK_EmailDoanhNghiep_ID]
GO
ALTER TABLE [dbo].[GiaoDich]  WITH CHECK ADD  CONSTRAINT [CK_GiaoDich_ID] CHECK  (([MaGiaoDich]>(0)))
GO
ALTER TABLE [dbo].[GiaoDich] CHECK CONSTRAINT [CK_GiaoDich_ID]
GO
ALTER TABLE [dbo].[GiaoDich]  WITH CHECK ADD  CONSTRAINT [CK_GiaoDich_TongTien] CHECK  (([TongTien]>=(0)))
GO
ALTER TABLE [dbo].[GiaoDich] CHECK CONSTRAINT [CK_GiaoDich_TongTien]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [CK_GioHang_ID] CHECK  (([MaGioHang]>(0)))
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [CK_GioHang_ID]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [CK_GioHang_SoTienGiam] CHECK  (([SoTienGiamThucTe]>=(0) AND [SoTienGiamThucTe]<=[TongTienChuaKhuyenMai]))
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [CK_GioHang_SoTienGiam]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [CK_GioHang_TTChuaKM] CHECK  (([TongTienChuaKhuyenMai]>=(0)))
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [CK_GioHang_TTChuaKM]
GO
ALTER TABLE [dbo].[HinhThucVanChuyen]  WITH CHECK ADD  CONSTRAINT [CK_HinhThucVanChuyen_ID] CHECK  (([MaHinhThucVanChuyen]>(0)))
GO
ALTER TABLE [dbo].[HinhThucVanChuyen] CHECK CONSTRAINT [CK_HinhThucVanChuyen_ID]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [CK_HopDong_ID] CHECK  (([MaHopDong]>(0)))
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [CK_HopDong_ID]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [CK_HopDong_Luong] CHECK  (([LuongThangThoaThuan]>=(0)))
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [CK_HopDong_Luong]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [CK_HopDong_Ngay] CHECK  (([NgayBatDau]<=[NgayKetThuc]))
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [CK_HopDong_Ngay]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [CK_HopDong_SoNgayCong] CHECK  (([SoNgayCongThangThoaThuan]>=(7) AND [SoNgayCongThangThoaThuan]<=(31)))
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [CK_HopDong_SoNgayCong]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [CK_KhachHang_Tuoi] CHECK  (((datepart(year,getdate())-datepart(year,[NgaySinh]))>=(16)))
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [CK_KhachHang_Tuoi]
GO
ALTER TABLE [dbo].[KhieuNaiDonHang]  WITH CHECK ADD  CONSTRAINT [CK_KhieuNaiDonHang_HaiLong] CHECK  (([MucDoHaiLongKhachHang]>=(0) AND [MucDoHaiLongKhachHang]<=(5)))
GO
ALTER TABLE [dbo].[KhieuNaiDonHang] CHECK CONSTRAINT [CK_KhieuNaiDonHang_HaiLong]
GO
ALTER TABLE [dbo].[KhieuNaiDonHang]  WITH CHECK ADD  CONSTRAINT [CK_KhieuNaiDonHang_NgayTao] CHECK  (([NgayTaoKhieuNai]<=getdate()))
GO
ALTER TABLE [dbo].[KhieuNaiDonHang] CHECK CONSTRAINT [CK_KhieuNaiDonHang_NgayTao]
GO
ALTER TABLE [dbo].[KhieuNaiDonHang]  WITH CHECK ADD  CONSTRAINT [CK_KhieuNaiDonHang_STT] CHECK  (([STT_KhieuNai]>(0)))
GO
ALTER TABLE [dbo].[KhieuNaiDonHang] CHECK CONSTRAINT [CK_KhieuNaiDonHang_STT]
GO
ALTER TABLE [dbo].[KhieuNaiDonHang]  WITH CHECK ADD  CONSTRAINT [CK_KhieuNaiDonHang_TrangThai] CHECK  (([TrangThaiXuLy]=(0) OR [TrangThaiXuLy]=(1) OR [TrangThaiXuLy]=(2)))
GO
ALTER TABLE [dbo].[KhieuNaiDonHang] CHECK CONSTRAINT [CK_KhieuNaiDonHang_TrangThai]
GO
ALTER TABLE [dbo].[KyLuong]  WITH CHECK ADD  CONSTRAINT [CK_KyLuong_Nam] CHECK  (([NamKyLuong]>=(1900) AND [NamKyLuong]<=datepart(year,getdate())))
GO
ALTER TABLE [dbo].[KyLuong] CHECK CONSTRAINT [CK_KyLuong_Nam]
GO
ALTER TABLE [dbo].[KyLuong]  WITH CHECK ADD  CONSTRAINT [CK_KyLuong_Thang] CHECK  (([ThangKyLuong]>=(1) AND [ThangKyLuong]<=(12)))
GO
ALTER TABLE [dbo].[KyLuong] CHECK CONSTRAINT [CK_KyLuong_Thang]
GO
ALTER TABLE [dbo].[LuongPhuCap]  WITH CHECK ADD  CONSTRAINT [CK_LuongPhuCap_ID] CHECK  (([MaPhuCap]>(0) AND [NhanVien]>(0)))
GO
ALTER TABLE [dbo].[LuongPhuCap] CHECK CONSTRAINT [CK_LuongPhuCap_ID]
GO
ALTER TABLE [dbo].[LuongPhuCap]  WITH CHECK ADD  CONSTRAINT [CK_LuongPhuCap_Nam] CHECK  (([NamKyLuong]>=(1900) AND [NamKyLuong]<=datepart(year,getdate())))
GO
ALTER TABLE [dbo].[LuongPhuCap] CHECK CONSTRAINT [CK_LuongPhuCap_Nam]
GO
ALTER TABLE [dbo].[LuongPhuCap]  WITH CHECK ADD  CONSTRAINT [CK_LuongPhuCap_Thang] CHECK  (([ThangKyLuong]>=(1) AND [ThangKyLuong]<=(12)))
GO
ALTER TABLE [dbo].[LuongPhuCap] CHECK CONSTRAINT [CK_LuongPhuCap_Thang]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [CK_NhanVien_ID] CHECK  (([MaNhanVien]>(0)))
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [CK_NhanVien_ID]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [CK_NhanVien_LoaiNhanVien] CHECK  (([LoaiNhanVien]=(0) OR [LoaiNhanVien]=(1)))
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [CK_NhanVien_LoaiNhanVien]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [CK_NhanVien_Tuoi] CHECK  (((datepart(year,getdate())-datepart(year,[NgaySinh]))>=(16)))
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [CK_NhanVien_Tuoi]
GO
ALTER TABLE [dbo].[PhuCap]  WITH CHECK ADD  CONSTRAINT [CK_PhuCap_ID] CHECK  (([MaPhuCap]>(0)))
GO
ALTER TABLE [dbo].[PhuCap] CHECK CONSTRAINT [CK_PhuCap_ID]
GO
ALTER TABLE [dbo].[PhuCap]  WITH CHECK ADD  CONSTRAINT [CK_PhuCap_SoTien] CHECK  (([SoTienPhuCap]>(0)))
GO
ALTER TABLE [dbo].[PhuCap] CHECK CONSTRAINT [CK_PhuCap_SoTien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_GiaGiam] CHECK  (([GiaGiam] IS NULL OR [GiaGiam]>=(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_GiaGiam]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_GiaHienHanh] CHECK  (([GiaHienHanh]>=(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_GiaHienHanh]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_GiaSi] CHECK  (([GiaSi] IS NULL OR [GiaSi]>=(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_GiaSi]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_ID] CHECK  (([MaSanPham]>(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_ID]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_NgayTao] CHECK  (([NgayTaoSanPham]<=getdate()))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_NgayTao]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_SLGiamGia] CHECK  (([SoLuongGiamGia] IS NULL OR [SoLuongGiamGia]>(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_SLGiamGia]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_SLSi] CHECK  (([SoLuongSi] IS NULL OR [SoLuongSi]>(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_SLSi]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [CK_SanPham_SLTon] CHECK  (([SoLuongTon]>=(0)))
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [CK_SanPham_SLTon]
GO
ALTER TABLE [dbo].[SanPhamYeuThich]  WITH CHECK ADD  CONSTRAINT [CK_SanPhamYeuThich_ID] CHECK  (([SanPham]>(0)))
GO
ALTER TABLE [dbo].[SanPhamYeuThich] CHECK CONSTRAINT [CK_SanPhamYeuThich_ID]
GO
ALTER TABLE [dbo].[SanPhamYeuThich]  WITH CHECK ADD  CONSTRAINT [CK_SanPhamYeuThich_ThoiGian] CHECK  (([ThoiGian]<=getdate()))
GO
ALTER TABLE [dbo].[SanPhamYeuThich] CHECK CONSTRAINT [CK_SanPhamYeuThich_ThoiGian]
GO
ALTER TABLE [dbo].[SoDiaChi]  WITH CHECK ADD  CONSTRAINT [CK_SoDiaChi_STT] CHECK  (([STT]>(0)))
GO
ALTER TABLE [dbo].[SoDiaChi] CHECK CONSTRAINT [CK_SoDiaChi_STT]
GO
ALTER TABLE [dbo].[TheoDoiNhaCungCap]  WITH CHECK ADD  CONSTRAINT [CK_TheoDoiNhaCungCap_Ngay] CHECK  (([NgayTheoDoi]<=getdate()))
GO
ALTER TABLE [dbo].[TheoDoiNhaCungCap] CHECK CONSTRAINT [CK_TheoDoiNhaCungCap_Ngay]
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen]  WITH CHECK ADD  CONSTRAINT [CK_ThongTinHinhThucVanChuyen_ID] CHECK  (([MaHinhThucVanChuyen]>(0)))
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen] CHECK CONSTRAINT [CK_ThongTinHinhThucVanChuyen_ID]
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen]  WITH CHECK ADD  CONSTRAINT [CK_ThongTinHinhThucVanChuyen_PhamVi] CHECK  (([PhamViVanChuyen]=(0) OR [PhamViVanChuyen]=(1)))
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen] CHECK CONSTRAINT [CK_ThongTinHinhThucVanChuyen_PhamVi]
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen]  WITH CHECK ADD  CONSTRAINT [CK_ThongTinHinhThucVanChuyen_PhiGiaoHang] CHECK  (([PhiGiaoHang]>(0)))
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen] CHECK CONSTRAINT [CK_ThongTinHinhThucVanChuyen_PhiGiaoHang]
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen]  WITH CHECK ADD  CONSTRAINT [CK_ThongTinHinhThucVanChuyen_ThoiGianGiao] CHECK  (([ThoiGianGiaoHang]>=(0)))
GO
ALTER TABLE [dbo].[ThongTinHinhThucVanChuyen] CHECK CONSTRAINT [CK_ThongTinHinhThucVanChuyen_ThoiGianGiao]
GO
ALTER TABLE [dbo].[ThongTinThanhToan]  WITH CHECK ADD  CONSTRAINT [CK_ThongTinThanhToan_LoaiPTTT] CHECK  (([LoaiPhuongThucThanhToan]=(0) OR [LoaiPhuongThucThanhToan]=(1) OR [LoaiPhuongThucThanhToan]=(2)))
GO
ALTER TABLE [dbo].[ThongTinThanhToan] CHECK CONSTRAINT [CK_ThongTinThanhToan_LoaiPTTT]
GO
ALTER TABLE [dbo].[ThongTinVanChuyen]  WITH CHECK ADD  CONSTRAINT [CK_ThongTinVanChuyen_ID] CHECK  (([NhanVienGiaoHang]>(0) AND [DonHang]>(0)))
GO
ALTER TABLE [dbo].[ThongTinVanChuyen] CHECK CONSTRAINT [CK_ThongTinVanChuyen_ID]
GO
ALTER TABLE [dbo].[ThongTinVanChuyen]  WITH CHECK ADD  CONSTRAINT [CK_ThongTinVanChuyen_ThoiGian] CHECK  (([ThoiGianVanChuyen]<=getdate()))
GO
ALTER TABLE [dbo].[ThongTinVanChuyen] CHECK CONSTRAINT [CK_ThongTinVanChuyen_ThoiGian]
GO
ALTER TABLE [dbo].[TinhThanhPho]  WITH CHECK ADD  CONSTRAINT [CK_TinhThanhPho_ID] CHECK  (([MaTinhThanhPho]>(0)))
GO
ALTER TABLE [dbo].[TinhThanhPho] CHECK CONSTRAINT [CK_TinhThanhPho_ID]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [CK_Voucher_GiaTriDonHang] CHECK  (([GiaTriDonHangToiThieu]>=(0)))
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [CK_Voucher_GiaTriDonHang]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [CK_Voucher_ID] CHECK  (([MaVoucher]>(0)))
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [CK_Voucher_ID]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [CK_Voucher_LoaiVoucher] CHECK  (([LoaiVoucher]=(0) OR [LoaiVoucher]=(1) OR [LoaiVoucher]=(2)))
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [CK_Voucher_LoaiVoucher]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [CK_Voucher_Ngay] CHECK  (([NgayBatDau]<=[NgayKetThuc]))
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [CK_Voucher_Ngay]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [CK_Voucher_PhanTramKhuyenMai] CHECK  (([PhanTramKhuyenMai] IS NULL OR [PhanTramKhuyenMai]>=(0.05) AND [PhanTramKhuyenMai]<=(1)))
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [CK_Voucher_PhanTramKhuyenMai]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [CK_Voucher_SoLuong] CHECK  (([SoLuongVoucher]>=(0)))
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [CK_Voucher_SoLuong]
GO
ALTER TABLE [dbo].[Voucher]  WITH CHECK ADD  CONSTRAINT [CK_Voucher_SoTien] CHECK  (([SoTienGiamToiDa]>=(0)))
GO
ALTER TABLE [dbo].[Voucher] CHECK CONSTRAINT [CK_Voucher_SoTien]
GO
ALTER TABLE [dbo].[VoucherApDung]  WITH CHECK ADD  CONSTRAINT [CK_VoucherApDung_ID] CHECK  (([MaVoucher]>(0) AND [MaGioHang]>(0)))
GO
ALTER TABLE [dbo].[VoucherApDung] CHECK CONSTRAINT [CK_VoucherApDung_ID]
GO
ALTER TABLE [dbo].[XemSanPham]  WITH CHECK ADD  CONSTRAINT [CK_XemSanPham_ID] CHECK  (([SanPham]>(0)))
GO
ALTER TABLE [dbo].[XemSanPham] CHECK CONSTRAINT [CK_XemSanPham_ID]
GO
ALTER TABLE [dbo].[XemSanPham]  WITH CHECK ADD  CONSTRAINT [CK_XemSanPham_ThoiGian] CHECK  (([ThoiGian]<=getdate()))
GO
ALTER TABLE [dbo].[XemSanPham] CHECK CONSTRAINT [CK_XemSanPham_ThoiGian]
GO
USE [master]
GO
ALTER DATABASE [NacoTikiDB] SET  READ_WRITE 
GO
