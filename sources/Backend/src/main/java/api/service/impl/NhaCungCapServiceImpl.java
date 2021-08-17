package api.service.impl;

import api.repository.NhaCungCapRepository;
import api.service.NhaCungCapService;
import api.service.dto.NhaCungCapDTO;
import api.service.mapper.NhaCungCapMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

    private final NhaCungCapRepository nhaCungCapRepository;

    private final NhaCungCapMapper nhaCungCapMapper;

    public NhaCungCapServiceImpl(NhaCungCapRepository nhaCungCapRepository, NhaCungCapMapper nhaCungCapMapper) {
        this.nhaCungCapRepository = nhaCungCapRepository;
        this.nhaCungCapMapper = nhaCungCapMapper;
    }

    @Override
    public Optional<NhaCungCapDTO> findOne(String keyword) {
        return nhaCungCapRepository.findById(keyword).map(nhaCungCapMapper::fromModelToDto);
    }

    @Override
    public Page<NhaCungCapDTO> findByKeyword(String keyword, Pageable pageable) {
        return nhaCungCapRepository.findAllByTenNhaCungCapContainsOrUsernameIs(keyword, keyword, pageable).map(nhaCungCapMapper::fromModelToDto);
    }
}
