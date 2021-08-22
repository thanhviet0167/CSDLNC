package api.service.impl;

import api.repository.DonHangRepository;
import api.repository.HinhThucVanChuyenRepository;
import api.repository.NhaCungCapRepository;
import api.repository.ThongTinCongThanhToanRepository;
import api.service.AdminStatisticsService;
import api.web.rest.vm.PaymentMethodStatisticsVM;
import api.web.rest.vm.TransportMethodStatisticsVM;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminStatisticsServiceImpl implements AdminStatisticsService {

    private final HinhThucVanChuyenRepository hinhThucVanChuyenRepository;
    private final ThongTinCongThanhToanRepository thongTinCongThanhToanRepository;
    private final NhaCungCapRepository nhaCungCapRepository;
    private final DonHangRepository donHangRepository;

    public AdminStatisticsServiceImpl(HinhThucVanChuyenRepository hinhThucVanChuyenRepository, ThongTinCongThanhToanRepository thongTinCongThanhToanRepository, NhaCungCapRepository nhaCungCapRepository, DonHangRepository donHangRepository) {
        this.hinhThucVanChuyenRepository = hinhThucVanChuyenRepository;
        this.thongTinCongThanhToanRepository = thongTinCongThanhToanRepository;
        this.nhaCungCapRepository = nhaCungCapRepository;
        this.donHangRepository = donHangRepository;
    }

    @Override
    public TransportMethodStatisticsVM getTransportMethodStatistics(String from, String to) {
        TransportMethodStatisticsVM transportMethodStatistics = new TransportMethodStatisticsVM();
        List<TransportMethodStatisticsVM.TransportMethodItem> transportMethodItems = new ArrayList<>();

        String[] froms = from.split("/");
        String[] tos = to.split("/");

        int fromMonth = Integer.parseInt(froms[0]);
        int fromYear = Integer.parseInt(froms[1]);

        int toMonth = Integer.parseInt(tos[0]);
        int toYear = Integer.parseInt(tos[1]);

        List<Object[]> resultList = hinhThucVanChuyenRepository.getTransportMethodStatistics(fromMonth, fromYear, toMonth, toYear);
        resultList.forEach(result -> {
            long id = ((BigInteger) result[0]).longValue();
            String methodName = (String) result[1];
            int count = (int) result[2];

            TransportMethodStatisticsVM.TransportMethodItem item = new TransportMethodStatisticsVM.TransportMethodItem(id, methodName, count);
            transportMethodItems.add(item);
        });

        transportMethodStatistics.setTuNgay(from);
        transportMethodStatistics.setDenNgay(to);
        transportMethodStatistics.setHinhThucVanChuyen(transportMethodItems);

        return transportMethodStatistics;
    }

    @Override
    public PaymentMethodStatisticsVM getPaymentMethodStatistics(String from, String to) {
        PaymentMethodStatisticsVM paymentMethodStatistics = new PaymentMethodStatisticsVM();
        List<PaymentMethodStatisticsVM.PaymentMethodItem> paymentMethodItems = new ArrayList<>();

        String[] froms = from.split("/");
        String[] tos = to.split("/");

        int fromMonth = Integer.parseInt(froms[0]);
        int fromYear = Integer.parseInt(froms[1]);

        int toMonth = Integer.parseInt(tos[0]);
        int toYear = Integer.parseInt(tos[1]);

        List<Object[]> resultList = thongTinCongThanhToanRepository.getPaymentMethodStatistics(fromMonth, fromYear, toMonth, toYear);
        resultList.forEach(result -> {
            String id = (String) result[0];
            String methodName = (String) result[1];
            int count = (int) result[2];

            PaymentMethodStatisticsVM.PaymentMethodItem item = new PaymentMethodStatisticsVM.PaymentMethodItem(id, methodName, count);
            paymentMethodItems.add(item);
        });

        paymentMethodStatistics.setTuNgay(from);
        paymentMethodStatistics.setDenNgay(to);
        paymentMethodStatistics.setCongThanhToan(paymentMethodItems);

        return paymentMethodStatistics;
    }
}
