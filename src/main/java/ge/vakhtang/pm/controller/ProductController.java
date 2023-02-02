package ge.vakhtang.pm.controller;

import ge.vakhtang.pm.entity.ProductEntity;
import ge.vakhtang.pm.model.request.AddProductAttributesRequest;
import ge.vakhtang.pm.model.request.ProductRegistrationRequest;
import ge.vakhtang.pm.model.response.GeneralResponse;
import ge.vakhtang.pm.model.response.GetProductsForUserResponse;
import ge.vakhtang.pm.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static ge.vakhtang.pm.component.utils.Constants.*;

@RestController
@RequestMapping("/products")
@Validated
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @PutMapping("/new")
    public ResponseEntity<GeneralResponse> registerNewProduct(@Valid @RequestBody final ProductRegistrationRequest request) {
        log.info(REQUEST_BODY_LOGGER_TEMPLATE, request);

        productService.registerNewProduct(request);
        return ResponseEntity.of(Optional.of(GeneralResponse.builder()
                .message(PRODUCT_REGISTRATION_GREETING_MESSAGE)
                .status(HttpStatus.CREATED.value())
                .build()));
    }

    @GetMapping("/get/forUser/{username}")
    public ResponseEntity<GeneralResponse> getProductsForUser(@PathVariable final String username) {
        List<ProductEntity> productsForUser = productService.getProductsForUser(username);
        return ResponseEntity.of(Optional.of(GetProductsForUserResponse.builder()
                .productEntities(productsForUser)
                .message(PRODUCTS_FOR_USER_HAVE_BEEN_GENERATED)
                .status(HttpStatus.OK.value())
                .build()));
    }

    @PostMapping("/attributes/add")
    public ResponseEntity<GeneralResponse> addAttributeForProduct(@Valid @RequestBody final AddProductAttributesRequest request) {
        productService.addProductAttributes(request);
        return ResponseEntity.of(Optional.of(GeneralResponse.builder()
                .message(PRODUCT_ATTRIBUTES_HAVE_BEEN_UPDATED)
                .status(HttpStatus.OK.value())
                .build()));
    }
}
