package api.web.rest.vm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PasswordChangeVM {

    @NotNull
    @Size(min = 1, max = 50)
    private String oldPassword;

    @NotNull
    @Size(min = 1, max = 50)
    private String newPassword;
}
