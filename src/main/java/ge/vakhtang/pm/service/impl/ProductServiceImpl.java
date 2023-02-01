package ge.vakhtang.pm.service.impl;

import ge.vakhtang.pm.entity.ProductEntity;
import ge.vakhtang.pm.entity.UserEntity;
import ge.vakhtang.pm.model.request.ProductRegistrationRequest;
import ge.vakhtang.pm.repository.ProductRepository;
import ge.vakhtang.pm.repository.UserRepository;
import ge.vakhtang.pm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public void registerNewProduct(ProductRegistrationRequest request) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(request.getName());
        productEntity.setQuantity(request.getQuantity());
        UserEntity userEntity = userRepository.getUserEntityByUsername(request.getUsername());
        productEntity.setUser(userEntity);
        productRepository.save(productEntity);
        productRepository.flush();
    }

    @Override
    public List<ProductEntity> getProductsForUser(String username) {
        UserEntity userEntity = userRepository.getUserEntityByUsername(username);
        return productRepository.getAllByUser(userEntity);
    }
}
