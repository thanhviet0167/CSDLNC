package api.service.impl;

import api.domain.BoSuuTap;
import api.repository.BoSuuTapRepository;
import api.service.BoSuuTapService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoSuuTapServiceImpl implements BoSuuTapService {

    private final BoSuuTapRepository boSuuTapRepository;

    public BoSuuTapServiceImpl(BoSuuTapRepository boSuuTapRepository) {
        this.boSuuTapRepository = boSuuTapRepository;
    }

    @Override
    public List<BoSuuTap> getStoreCollection(String store) {
        return boSuuTapRepository.findAllByBoSuuTapID_Username(store);
    }

    @Override
    public Optional<BoSuuTap> getCollection(String store, Integer stt) {
        return boSuuTapRepository.findByBoSuuTapID_UsernameAndBoSuuTapID_Stt(store, stt);
    }
}
