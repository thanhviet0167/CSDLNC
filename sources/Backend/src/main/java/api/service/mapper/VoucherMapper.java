package api.service.mapper;

import api.domain.Voucher;
import api.service.dto.VoucherDTO;

import java.util.List;

public interface VoucherMapper {

    public List<VoucherDTO> fromModelToDtos(List<Voucher> vouchers);

    public VoucherDTO fromModelToDto(Voucher voucher);

    public Voucher fromDtoToModel(VoucherDTO voucherDTO);

    public List<Voucher> fromDtoToModels(List<VoucherDTO> voucherDTOS);

}
