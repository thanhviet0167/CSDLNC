package api.web.rest.vm;

import api.service.dto.KhachHangDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class ManagedUserVM extends KhachHangDTO {
    public static final int PASSWORD_MIN_LENGTH = 5;

    public static final int PASSWORD_MAX_LENGTH = 50;

    @Size(min = 5, max = 50)
    private String password;
}
