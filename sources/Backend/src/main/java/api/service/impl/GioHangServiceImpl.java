package api.service.impl;

import api.domain.*;
import api.repository.*;
import api.service.GioHangService;
import api.service.NhaCungCapService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GioHangServiceImpl implements GioHangService {

    private final GioHangRepository gioHangRepository;
    private final ChiTietGioHangRepository chiTietGioHangRepository;
    private final VoucherApDungRepository voucherApDungRepository;
    private final ChiTietQuaTangRepository chiTietQuaTangRepository;
    private final KhachHangRepository khachHangRepository;
    private final NhaCungCapRepository nhaCungCapRepository;

    public GioHangServiceImpl(GioHangRepository gioHangRepository, ChiTietGioHangRepository chiTietGioHangRepository, VoucherApDungRepository voucherApDungRepository, ChiTietQuaTangRepository chiTietQuaTangRepository, KhachHangRepository khachHangRepository, NhaCungCapRepository nhaCungCapRepository) {
        this.gioHangRepository = gioHangRepository;
        this.chiTietGioHangRepository = chiTietGioHangRepository;
        this.voucherApDungRepository = voucherApDungRepository;
        this.chiTietQuaTangRepository = chiTietQuaTangRepository;
        this.khachHangRepository = khachHangRepository;
        this.nhaCungCapRepository = nhaCungCapRepository;
    }

    @Override
    public List<GioHang> findAllCartNotOrder(String khachHang) {

        return gioHangRepository.findAllByKhachHangAndTrangThaiDatHang(khachHang, 0);
    }

    @Override
    public Optional<GioHang> findOne(Long maGioHang) {
        return gioHangRepository.findByMaGioHang(maGioHang);
    }

    @Override
    public void delete(Long maGioHang) {
        gioHangRepository.deleteById(maGioHang);
    }

    @Override
    @Transactional
    public GioHang create(GioHang gioHang, KhachHang khachHang) {
        /*
        * {
            "nhaCungCap": {
                "username": "Copley999"
            },
            "tongTienChuaKhuyenMai": 4919039,
            "tongTienQuaTang": 360423,
            "soTienGiamThucTe": 360423,
            "voucher": {
                "maVoucher": 315
            },
            "soDiaChi": {
                "soDiaChiID": {
                    "username": "Acevedo2001",
                    "stt": 36
                }
            },
            "chiTietGioHangSet": [
                {
                    "chiTietGioHangID": {
                        "maSanPham": 1931
                    },
                    "soLuongMua": 43,
                    "giaBanThucTe": 2634935,
                    "giaGiam": 597466
                },
                {
                    "chiTietGioHangID": {
                        "maSanPham": 1932
                    },
                    "soLuongMua": 18,
                    "giaBanThucTe": 2759148,
                    "giaGiam": 201284
                }
            ],
            "voucherApDungSet": [
                {
                    "voucherApDungID": {
                        "maVoucher": 1932
                    },
                    "chiTietQuaTangSet": [
                        {
                            "chiTietQuaTangID": {
                                "sanPhamTangKem": 1932
                            },
                            "giaBanTangKem": 371930,
                            "soLuongTangKem": 6
                        }
                    ]
                }
            ]
        }
        * */

        // create cart
        GioHang newGioHang = new GioHang();

        newGioHang.setKhachHang(khachHang);
        newGioHang.setNhaCungCap(gioHang.getNhaCungCap());
        newGioHang.setTongTienChuaKhuyenMai(gioHang.getTongTienChuaKhuyenMai());
        newGioHang.setTongTienQuaTang(gioHang.getTongTienQuaTang());
        newGioHang.setSoTienGiamThucTe(gioHang.getSoTienGiamThucTe());
        newGioHang.setTrangThaiDatHang(false);
        newGioHang.setVoucher(gioHang.getVoucher());
        newGioHang.setSttSoDiaChi(gioHang.getSoDiaChi().getSoDiaChiID().getStt());

        GioHang gioHangResult = gioHangRepository.save(newGioHang);

        // create cart detail
        List<ChiTietGioHang> chiTietGioHangList = gioHang.getChiTietGioHangSet().stream().map(ct -> {
            ChiTietGioHang chiTietGioHang = new ChiTietGioHang();

            ChiTietGioHang.ChiTietGioHangID id = new ChiTietGioHang.ChiTietGioHangID();
            id.setMaGioHang(gioHangResult.getMaGioHang());
            id.setMaSanPham(ct.getChiTietGioHangID().getMaSanPham());

            chiTietGioHang.setChiTietGioHangID(id);
            chiTietGioHang.setSoLuongMua(ct.getSoLuongMua());
            chiTietGioHang.setGiaBanThucTe(ct.getGiaBanThucTe());
            chiTietGioHang.setGiaGiam(ct.getGiaGiam());

            return chiTietGioHang;
        }).collect(Collectors.toList());

        // create apply voucher detail

        List<VoucherApDung> applyVoucher = new ArrayList<>();
        List<ChiTietQuaTang> chiTietQuaTangList = new ArrayList<>();

        gioHang.getVoucherApDungSet().forEach(ct -> {
            VoucherApDung voucherApDung = new VoucherApDung();

            VoucherApDung.VoucherApDungID voucherApDungID = new VoucherApDung.VoucherApDungID();
            voucherApDungID.setMaGioHang(gioHangResult.getMaGioHang());
            voucherApDungID.setMaVoucher(ct.getVoucherApDungID().getMaVoucher());

            voucherApDung.setVoucherApDungID(voucherApDungID);
            applyVoucher.add(voucherApDung);

            List<ChiTietQuaTang> chiTietQuaTangs = ct.getChiTietQuaTangSet().stream().map(ct1 -> {
                ChiTietQuaTang chiTietQuaTang = new ChiTietQuaTang();

                ChiTietQuaTang.ChiTietQuaTangID chiTietQuaTangID = new ChiTietQuaTang.ChiTietQuaTangID();

                chiTietQuaTangID.setMaGioHang(gioHangResult.getMaGioHang());
                chiTietQuaTangID.setMaVoucher(ct.getVoucherApDungID().getMaVoucher());
                chiTietQuaTangID.setSanPhamTangKem(ct1.getChiTietQuaTangID().getSanPhamTangKem());

                chiTietQuaTang.setChiTietQuaTangID(chiTietQuaTangID);
                chiTietQuaTang.setGiaBanTangKem(ct1.getGiaBanTangKem());
                chiTietQuaTang.setSoLuongTangKem(ct1.getSoLuongTangKem());

                return chiTietQuaTang;
            }).collect(Collectors.toList());

            chiTietQuaTangList.addAll(chiTietQuaTangs);
        });

        List<ChiTietGioHang> result1 = chiTietGioHangRepository.saveAll(chiTietGioHangList);
        List<VoucherApDung> result3 = voucherApDungRepository.saveAll(applyVoucher);
        List<ChiTietQuaTang> result2 = chiTietQuaTangRepository.saveAll(chiTietQuaTangList);

        gioHangResult.setChiTietGioHangSet(new HashSet<>(result1));
        gioHangResult.setVoucherApDungSet(new HashSet<>(result3));

        Optional<GioHang> finalGioHang = gioHangRepository.findByMaGioHang(gioHangResult.getMaGioHang());

        return finalGioHang.get();
    }
}
