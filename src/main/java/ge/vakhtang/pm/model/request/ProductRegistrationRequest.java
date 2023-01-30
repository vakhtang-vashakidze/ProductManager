package ge.vakhtang.pm.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductRegistrationRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String quantity;
    @NotBlank
    private String accessToken;
}
