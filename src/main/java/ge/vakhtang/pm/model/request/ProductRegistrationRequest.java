package ge.vakhtang.pm.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ProductRegistrationRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @PositiveOrZero
    private Double price;
    @PositiveOrZero
    private Integer quantity;
    @NotBlank
    private String currencyCode;
    @NotBlank
    private String username;
}
