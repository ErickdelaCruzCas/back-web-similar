package com.prueba.backwebsimilar.services;

import com.baeldung.openapi.model.ProductDetail;
import com.prueba.backwebsimilar.ports.in.ProductServicePort;
import com.prueba.backwebsimilar.ports.out.ProductClientPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Repository
@AllArgsConstructor
public class ProductService implements ProductServicePort {

    private final ProductClientPort productClientPort;

    @Override
    public Set<ProductDetail> getProductSimilar(String id) {
        return  productClientPort.getSimilarProducts(id).stream()
                .map(productClientPort::getProductDetail).collect(Collectors.toSet());
    }
}
