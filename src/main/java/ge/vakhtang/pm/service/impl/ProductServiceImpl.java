package ge.vakhtang.pm.service.impl;

import ge.vakhtang.pm.entity.CurrencyEntity;
import ge.vakhtang.pm.entity.ProductAttributeEntity;
import ge.vakhtang.pm.entity.ProductEntity;
import ge.vakhtang.pm.entity.UserEntity;
import ge.vakhtang.pm.model.request.AddProductAttributesRequest;
import ge.vakhtang.pm.model.request.ProductRegistrationRequest;
import ge.vakhtang.pm.repository.CurrencyRepository;
import ge.vakhtang.pm.repository.ProductRepository;
import ge.vakhtang.pm.repository.UserRepository;
import ge.vakhtang.pm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ge.vakhtang.pm.component.utils.Constants.DEFAULT_ID;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    @Override
    public void registerNewProduct(ProductRegistrationRequest request) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(request.getName());
        productEntity.setQuantity(request.getQuantity());
        productEntity.setDescription(request.getDescription());
        productEntity.setPrice(request.getPrice());
        productEntity.setRegistrationTime(LocalDateTime.now());
        UserEntity userEntity = userRepository.getUserEntityByUsername(request.getUsername());
        CurrencyEntity currencyEntity = currencyRepository.getByCode(request.getCurrencyCode());
        //TODO replace later
        if (currencyEntity == null) {
            currencyEntity = new CurrencyEntity();
            currencyEntity.setCode(request.getCurrencyCode());
        }
        productEntity.setCurrency(currencyEntity);
        productEntity.setUser(userEntity);
        productRepository.save(productEntity);
        productRepository.flush();
    }

    @Override
    public List<ProductEntity> getProductsForUser(String username) {
        UserEntity userEntity = userRepository.getUserEntityByUsername(username);
        return productRepository.getAllByUser(userEntity);
    }

    @Override
    public void addProductAttributes(AddProductAttributesRequest request) {
        ProductEntity productEntity = productRepository.getById(request.getProductId());
        Set<ProductAttributeEntity> productAttributeEntities = request.getAttributes().stream().map(attribute ->
                        new ProductAttributeEntity(DEFAULT_ID, attribute.getName(), attribute.getType(), attribute.getValue(), productEntity))
                .collect(Collectors.toSet());
        productEntity.setAttributes(productAttributeEntities);
        productRepository.save(productEntity);
        productRepository.flush();
    }
}
