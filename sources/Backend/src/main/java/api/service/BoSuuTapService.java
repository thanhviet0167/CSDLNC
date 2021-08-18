package api.service;

import api.domain.BoSuuTap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BoSuuTapService {
    List<BoSuuTap> getStoreCollection(String store);
    Optional<BoSuuTap> getCollection(String store, Integer stt);
}
