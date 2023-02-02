package ge.vakhtang.pm.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ProductRegistrationRequest {
    @NotBlank
    private String name;
    @PositiveOrZero
    private Integer quantity;
    @NotBlank
    private String username;
    @NotBlank
    private String description;
}
