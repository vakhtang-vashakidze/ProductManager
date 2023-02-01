package ge.vakhtang.pm.model.response;

import ge.vakhtang.pm.entity.ProductEntity;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public class GetProductsForUserResponse extends GeneralResponse{
    private List<ProductEntity> productEntities;
}
