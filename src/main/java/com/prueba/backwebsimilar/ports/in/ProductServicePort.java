package com.prueba.backwebsimilar.ports.in;

import com.baeldung.openapi.model.ProductDetail;

import java.util.Set;

public interface ProductServicePort {

    Set<ProductDetail> getProductSimilar(String id);

}
