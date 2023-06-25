package com.prueba.backwebsimilar.api.adapters;

import com.baeldung.openapi.api.ProductApi;
import com.baeldung.openapi.model.ProductDetail;
import com.prueba.backwebsimilar.ports.in.ProductServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping
public class ProductControllerAdapter  implements ProductApi {

    private final ProductServicePort productServicePort;

    @Override
    public ResponseEntity<Set<ProductDetail>> getProductSimilar(String productId) {
        log.info("Request similar products with productId: {}", productId);
        return ResponseEntity.ok(productServicePort.getProductSimilar(productId));
    }

}
