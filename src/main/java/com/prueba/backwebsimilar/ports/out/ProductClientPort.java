package com.prueba.backwebsimilar.ports.out;

import com.baeldung.openapi.model.ProductDetail;
import com.prueba.backwebsimilar.ports.out.config.ProductClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(
        contextId = "productClient",
        name = "productClient",
        url = "${remote.product.url}",
        configuration = ProductClientConfiguration.class
)
public interface ProductClientPort {

    @GetMapping("/product/{productId}/similarids")
    Set<String> getSimilarProducts(@PathVariable("productId")String productId);

    @GetMapping("/product/{productId}")
    ProductDetail getProductDetail(@PathVariable("productId")String productId);
}
