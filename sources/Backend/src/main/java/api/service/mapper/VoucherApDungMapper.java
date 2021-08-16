package api.service.mapper;

import api.domain.VoucherApDung;
import api.service.dto.VoucherApDungDTO;

import java.util.List;

public interface VoucherApDungMapper {

    public List<VoucherApDungDTO> fromModelToDtos(List<VoucherApDung> voucherApDungs);

    public VoucherApDungDTO fromModelToDto(VoucherApDung voucherApDung);

    public VoucherApDung fromDtoToModel(VoucherApDungDTO voucherApDungDTO);

    public List<VoucherApDung> fromDtoToModels(List<VoucherApDungDTO> voucherApDungDTOS);

}
