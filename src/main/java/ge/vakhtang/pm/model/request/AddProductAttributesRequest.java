package ge.vakhtang.pm.model.request;

import ge.vakhtang.pm.model.service.Attribute;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Data
public class AddProductAttributesRequest {
    @PositiveOrZero
    private Integer productId;
    @NotBlank
    private String username;
    @NotEmpty
    @NotNull
    private Set<Attribute> attributes;
}
