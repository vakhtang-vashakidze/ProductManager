package ge.vakhtang.pm.service;

import ge.vakhtang.pm.entity.ProductEntity;
import ge.vakhtang.pm.model.request.AddProductAttributesRequest;
import ge.vakhtang.pm.model.request.ProductRegistrationRequest;

import java.util.List;

public interface ProductService {
    void registerNewProduct(ProductRegistrationRequest request);
    List<ProductEntity> getProductsForUser(String username);
    void addProductAttributes(AddProductAttributesRequest request);
}
