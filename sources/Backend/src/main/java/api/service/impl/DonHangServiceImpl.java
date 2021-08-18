package api.service.impl;

import api.domain.*;
import api.repository.*;
import api.service.DonHangService;
import api.web.rest.vm.CompleteOrderVM;
import api.web.rest.vm.OrderVM;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonHangServiceImpl implements DonHangService {

    private final DonHangRepository donHangRepository;
    private final GiaoDichRepository giaoDichRepository;
    private final GioHangRepository gioHangRepository;
    private final PhuongThucThanhToanRepository phuongThucThanhToanRepository;
    private final ThongTinThanhToanRepository thongTinThanhToanRepository;

    public DonHangServiceImpl(DonHangRepository donHangRepository, GiaoDichRepository giaoDichRepository, GioHangRepository gioHangRepository, PhuongThucThanhToanRepository phuongThucThanhToanRepository, ThongTinThanhToanRepository thongTinThanhToanRepository) {
        this.donHangRepository = donHangRepository;
        this.giaoDichRepository = giaoDichRepository;
        this.gioHangRepository = gioHangRepository;
        this.phuongThucThanhToanRepository = phuongThucThanhToanRepository;
        this.thongTinThanhToanRepository = thongTinThanhToanRepository;
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
}
