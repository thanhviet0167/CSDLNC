package api.repository.impl;

import api.domain.KhachHang;
import api.repository.KhachHangRepositoryCustom;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;
import java.util.Optional;

@Component
public class KhachHangRepositoryCustomImpl implements KhachHangRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager; //thao tac voi database

    public Optional<KhachHang> findByQuery(Map<String, String> args) {
        //code
        return null;
    }

}
