package api.repository;

import api.domain.KhachHang;

import java.util.Map;
import java.util.Optional;

public interface KhachHangRepositoryCustom { //Khai bao cac function cho custom query
    Optional<KhachHang> findByQuery(Map<String, String> args);
}
