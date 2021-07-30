USE [master]
GO
/****** Object:  Database [NacoTikiDB]    Script Date: 7/30/2021 5:53:52 PM ******/
CREATE DATABASE [NacoTikiDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'NacoTikiDB', FILENAME = N'D:\NacoTikiDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'NacoTikiDB_log', FILENAME = N'D:\NacoTikiDB_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
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
/****** Object:  Table [dbo].[BoSuuTap]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[ChiTietGioHang]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietGioHang](
	[MaGioHang] [bigint] NOT NULL,
	[MaSanPham] [bigint] NOT NULL,
	[SoLuongMua] [smallint] NOT NULL,
	[GiaBanThucTe] [bigint] NOT NULL,
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
/****** Object:  Table [dbo].[ChiTietQuaTang]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[ChiTietVoucher]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[MaDanhMuc] [bigint] NOT NULL,
	[TenDanhMuc] [nvarchar](50) NOT NULL,
	[MoTa] [ntext] NULL,
 CONSTRAINT [PK_DanhMuc] PRIMARY KEY CLUSTERED 
(
	[MaDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMucSanPham]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMucSanPham](
	[MaDanhMucSanPham] [bigint] NOT NULL,
	[TenDanhMucSanPham] [nvarchar](50) NOT NULL,
	[MoTa] [ntext] NULL,
	[DanhMuc] [bigint] NOT NULL,
 CONSTRAINT [PK_DanhMucSanPham] PRIMARY KEY CLUSTERED 
(
	[MaDanhMucSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[MaDonHang] [bigint] NOT NULL,
	[TrangThaiThanhToan] [tinyint] NOT NULL,
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
/****** Object:  Table [dbo].[EmailDoanhNghiep]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[GiaoDich]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaoDich](
	[MaGiaoDich] [bigint] NOT NULL,
	[TongTien] [bigint] NULL,
	[TrangThaiThanhToan] [tinyint] NOT NULL,
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
/****** Object:  Table [dbo].[GioHang]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHang](
	[MaGioHang] [bigint] NOT NULL,
	[KhachHang] [varchar](20) NOT NULL,
	[NhaCungCap] [varchar](20) NOT NULL,
	[TongTienChuaKhuyenMai] [bigint] NULL,
	[TrangThaiDatHang] [bit] NOT NULL,
	[MaVoucher] [bigint] NULL,
	[SoTienGiamThucTe] [bigint] NULL,
	[STT_SoDiaChi] [tinyint] NULL,
 CONSTRAINT [PK_GioHang] PRIMARY KEY CLUSTERED 
(
	[MaGioHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucVanChuyen]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucVanChuyen](
	[MaHinhThucVanChuyen] [bigint] NOT NULL,
	[TenHinhThucVanChuyen] [nvarchar](50) NULL,
 CONSTRAINT [PK_HinhThucVanChuyen] PRIMARY KEY CLUSTERED 
(
	[MaHinhThucVanChuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 7/30/2021 5:53:52 PM ******/
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
	[NgaySinh] [bigint] NULL,
	[AnhDaiDien] [varchar](100) NULL,
	[SDT_DangKy] [varchar](11) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [bigint] NOT NULL,
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
/****** Object:  Table [dbo].[PhuongThucThanhToan]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[SanPham]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [bigint] NOT NULL,
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
	[NhaCungCap] [bigint] NOT NULL,
	[STT_BoSuuTap] [int] NULL,
	[NgayTaoSanPham] [datetime] NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPhamYeuThich]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[SoDiaChi]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[TheoDoiNhaCungCap]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[ThongTinCongThanhToan]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[ThongTinHinhThucVanChuyen]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThongTinHinhThucVanChuyen](
	[MaHinhThucVanChuyen] [bigint] NOT NULL,
	[PhamViVanChuyen] [nvarchar](50) NOT NULL,
	[PhiGiaoHang] [bigint] NULL,
	[ThoiGianGiaoHang] [tinyint] NULL,
 CONSTRAINT [PK_ThongTinHinhThucVanChuyen] PRIMARY KEY CLUSTERED 
(
	[MaHinhThucVanChuyen] ASC,
	[PhamViVanChuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinThanhToan]    Script Date: 7/30/2021 5:53:52 PM ******/
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
	[LoaiThe] [varchar](50) NOT NULL,
	[NgayHetHan] [datetime] NULL,
 CONSTRAINT [PK_ThongTinThanhToan] PRIMARY KEY CLUSTERED 
(
	[TaiKhoanThanhToan] ASC,
	[CongThanhToan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThongTinVanChuyen]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[TinhThanhPho]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[Voucher]    Script Date: 7/30/2021 5:53:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[MaVoucher] [bigint] NOT NULL,
	[SoLuongVoucher] [smallint] NOT NULL,
	[NgayBatDau] [datetime] NOT NULL,
	[NgayKetThuc] [datetime] NOT NULL,
	[LoaiVoucher] [tinyint] NOT NULL,
	[GiaTriDonHangToiThieu] [bigint] NULL,
	[PhanTramKhuyenMai] [float] NULL,
	[SoTienGiamToiDa] [bigint] NULL,
	[SanPhamApDung] [bigint] NULL,
	[SoLuongApDung] [smallint] NULL,
	[NhaCungCap] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Voucher] PRIMARY KEY CLUSTERED 
(
	[MaVoucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VoucherApDung]    Script Date: 7/30/2021 5:53:52 PM ******/
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
/****** Object:  Table [dbo].[XemSanPham]    Script Date: 7/30/2021 5:53:52 PM ******/
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
ALTER TABLE [dbo].[BoSuuTap]  WITH CHECK ADD  CONSTRAINT [FK_BoSuuTap_NhaCungCap] FOREIGN KEY([Username])
REFERENCES [dbo].[NhaCungCap] ([Username])
GO
ALTER TABLE [dbo].[BoSuuTap] CHECK CONSTRAINT [FK_BoSuuTap_NhaCungCap]
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
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_NhaCungCap] FOREIGN KEY([Username])
REFERENCES [dbo].[NhaCungCap] ([Username])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_NhaCungCap]
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
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_DanhMucSanPham] FOREIGN KEY([DanhMucSanPham])
REFERENCES [dbo].[DanhMucSanPham] ([MaDanhMucSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_DanhMucSanPham]
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
USE [master]
GO
ALTER DATABASE [NacoTikiDB] SET  READ_WRITE 
GO
