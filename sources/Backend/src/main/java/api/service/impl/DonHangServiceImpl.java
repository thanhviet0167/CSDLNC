package api.service.impl;

import api.domain.*;
import api.repository.*;
import api.service.DonHangService;
import api.web.rest.vm.CompleteOrderVM;
import api.web.rest.vm.CompleteTransactionVM;
import api.web.rest.vm.OrderVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DonHangServiceImpl implements DonHangService {

    private final DonHangRepository donHangRepository;
    private final GiaoDichRepository giaoDichRepository;
    private final GioHangRepository gioHangRepository;
    private final PhuongThucThanhToanRepository phuongThucThanhToanRepository;
    private final ThongTinThanhToanRepository thongTinThanhToanRepository;
    private final ThongTinVanChuyenRepository thongTinVanChuyenRepository;

    public DonHangServiceImpl(DonHangRepository donHangRepository, GiaoDichRepository giaoDichRepository, GioHangRepository gioHangRepository, PhuongThucThanhToanRepository phuongThucThanhToanRepository, ThongTinThanhToanRepository thongTinThanhToanRepository, ThongTinVanChuyenRepository thongTinVanChuyenRepository) {
        this.donHangRepository = donHangRepository;
        this.giaoDichRepository = giaoDichRepository;
        this.gioHangRepository = gioHangRepository;
        this.phuongThucThanhToanRepository = phuongThucThanhToanRepository;
        this.thongTinThanhToanRepository = thongTinThanhToanRepository;
        this.thongTinVanChuyenRepository = thongTinVanChuyenRepository;
    }

    @Override
    public List<DonHang> getAllByKhachHangAndStatus(String khachHang, Integer status) {
        return donHangRepository.findAllByKhachHang(khachHang, status);
    }

    @Override
    public Optional<DonHang> getOne(Long id) {
        return donHangRepository.findById(id);
    }

    @Override
    @Transactional
    public CompleteOrderVM create(OrderVM donHangVM, KhachHang khachHang) {

        List<GioHang> gioHangList = donHangVM.getGioHangList().stream().map(gioHang -> {
            Optional<GioHang> gioHangOptional = gioHangRepository.findByMaGioHang(gioHang.getMaGioHang());

            if (gioHangOptional.isPresent()) {
                GioHang gioHang1 = gioHangOptional.get();
                gioHang1.setPhiVanChuyen(gioHang.getPhiVanChuyen());

                return gioHang1;
            }

            return null;
        }).collect(Collectors.toList());

        // tao giao dich giao dich
        GiaoDich giaoDich = new GiaoDich();

        final Long[] tongTien = {0L};

        gioHangList.forEach(gioHang -> {
            Long thanhTien = (gioHang.getTongTienQuaTang() != null ? gioHang.getTongTienQuaTang() : 0L)
                    + (gioHang.getTongTienChuaKhuyenMai() != null ? gioHang.getTongTienChuaKhuyenMai() : 0L)
                    - (gioHang.getSoTienGiamThucTe() != null ? gioHang.getSoTienGiamThucTe() : 0L);

            tongTien[0] = tongTien[0] + thanhTien + gioHang.getPhiVanChuyen();
        });

        giaoDich.setPhuongThucThanhToan(donHangVM.getPhuongThucThanhToan());
        giaoDich.setNgayThanhToan(Instant.now());
        giaoDich.setTongTien(tongTien[0]);
        giaoDich.setTrangThaiThanhToan(false);

        GiaoDich giaoDichResult = giaoDichRepository.save(giaoDich);

        PhuongThucThanhToan phuongThucThanhToan = phuongThucThanhToanRepository.findByPhuongThucThanhToanID_UsernameAndPhuongThucThanhToanID_TaiKhoanThanhToanAndPhuongThucThanhToanID_CongThanhToan(
                giaoDichResult.getPhuongThucThanhToan().getPhuongThucThanhToanID().getUsername(),
                giaoDichResult.getPhuongThucThanhToan().getPhuongThucThanhToanID().getTaiKhoanThanhToan(),
                giaoDichResult.getPhuongThucThanhToan().getPhuongThucThanhToanID().getCongThanhToan()
        );

        giaoDichResult.setPhuongThucThanhToan(phuongThucThanhToan);

        gioHangList.forEach(gioHang -> {
                donHangRepository.capNhatHangTon(gioHang.getMaGioHang());
            }
        );

        // cap nhat trang thai gio hang
        List<GioHang> gioHangResultList = gioHangList.stream().map(gioHang -> {
            if (gioHang == null) return null;

            Optional<GioHang> gioHangOptional = gioHangRepository.findById(gioHang.getMaGioHang());

            if (gioHangOptional.isPresent()) {
                GioHang gioHang1 = gioHangOptional.get();
                gioHang1.setTrangThaiDatHang(true);

                return gioHangRepository.save(gioHang1);
            }

            return null;
        }).collect(Collectors.toList());

        // tao don hang
        List<DonHang> donHangResultList = gioHangResultList.stream().map(gioHang -> {
            DonHang donHang1 = new DonHang();

            Long thanhTien = (gioHang.getTongTienQuaTang() != null ? gioHang.getTongTienQuaTang() : 0L)
                    + (gioHang.getTongTienChuaKhuyenMai() != null ? gioHang.getTongTienChuaKhuyenMai() : 0L)
                    - (gioHang.getSoTienGiamThucTe() != null ? gioHang.getSoTienGiamThucTe() : 0L);

            donHang1.setGioHang(gioHang);
            donHang1.setGiaoDich(giaoDichResult);
            donHang1.setTrangThaiThanhToan(false);
            donHang1.setHinhThucVanChuyen(donHangVM.getHinhThucVanChuyen());
            donHang1.setNgayDat(Instant.now());
            donHang1.setPhiVanChuyen(gioHang.getPhiVanChuyen());
            donHang1.setThanhTien(thanhTien);

            return donHangRepository.save(donHang1);
        }).collect(Collectors.toList());

        // tra ve don hang chua giao dich
        CompleteOrderVM completeOrderVM = new CompleteOrderVM();
        completeOrderVM.setDonHangList(donHangResultList);
        completeOrderVM.setGiaoDich(giaoDichResult);

        return completeOrderVM;
    }

    @Override
    @Transactional
    public CompleteTransactionVM payment(GiaoDich giaoDich) {

        // cap nhat trang thai giao dich
        Optional<GiaoDich> giaoDichOptional = giaoDichRepository.findById(giaoDich.getMaGiaoDich());

        GiaoDich giaoDich1 = giaoDichOptional.get();

        giaoDich1.setTrangThaiThanhToan(true);
        giaoDich1.setNgayThanhToan(Instant.now());

        GiaoDich giaoDichResult = giaoDichRepository.save(giaoDich1);

        // cap nhat trang thai hoa don
        List<DonHang> donHangList = donHangRepository.findAllByGiaoDich(giaoDich.getMaGiaoDich());

        Random random = new Random();

        List<DonHang> donHangResult = donHangList.stream().map(donHang -> {
            donHang.setTrangThaiThanhToan(true);

            donHangRepository.save(donHang);

            // tao thong tin van chuyen cho moi hoa don voi status Đơn hàng đang được xử lý
            ThongTinVanChuyen thongTinVanChuyen = new ThongTinVanChuyen();

            ThongTinVanChuyen.ThongTinVanChuyenID thongTinVanChuyenID = new ThongTinVanChuyen.ThongTinVanChuyenID();
            long nhanVienID = random.nextInt(1000);
            thongTinVanChuyenID.setNhanVienGiaoHang(nhanVienID);
            thongTinVanChuyenID.setDonHang(donHang.getMaDonHang());

            thongTinVanChuyen.setThongTinVanChuyenID(thongTinVanChuyenID);
            thongTinVanChuyen.setThoiGianVanChuyen(Instant.now());
            thongTinVanChuyen.setTrangThaiVanChuyen("Đơn hàng đang được xử lý");

            thongTinVanChuyenRepository.save(thongTinVanChuyen);

            Set<ThongTinVanChuyen> thongTinVanChuyenSet = new HashSet<>();
            thongTinVanChuyenSet.add(thongTinVanChuyen);

            donHang.setThongTinVanChuyenSet(thongTinVanChuyenSet);

            return donHang;
        }).collect(Collectors.toList());

        CompleteTransactionVM completeTransactionVM = new CompleteTransactionVM();
        completeTransactionVM.setGiaoDich(giaoDichResult);
        completeTransactionVM.setDonHangList(donHangResult);

        return completeTransactionVM;
    }
}
