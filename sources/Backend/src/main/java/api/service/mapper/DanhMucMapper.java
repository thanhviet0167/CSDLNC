package api.service.mapper;

import api.domain.DanhMuc;
import api.domain.KhachHang;
import api.service.dto.DanhMucDTO;
import api.service.dto.KhachHangDTO;
import api.web.rest.vm.ManagedUserVM;

import java.util.List;

public interface DanhMucMapper {

    public List<DanhMucDTO> fromModelToDtos(List<DanhMuc> danhMucs);

    public DanhMucDTO fromModelToDto(DanhMuc danhMuc);

    public DanhMuc fromDtoToModel(DanhMucDTO danhMucDTO);

    public List<DanhMuc> fromDtoToModels(List<DanhMucDTO> danhMucDTOS);

}
