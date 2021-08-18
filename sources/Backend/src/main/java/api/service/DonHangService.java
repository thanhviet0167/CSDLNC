package api.service;

import api.domain.DonHang;
import api.domain.KhachHang;
import api.web.rest.vm.CompleteOrderVM;
import api.web.rest.vm.OrderVM;

import java.util.List;
import java.util.Optional;

public interface DonHangService {
    List<DonHang> getAllByKhachHangAndStatus(String khachHang, Integer status);

    Optional<DonHang> getOne(Long id);

    CompleteOrderVM create(OrderVM donHang, KhachHang khachHang);
}
