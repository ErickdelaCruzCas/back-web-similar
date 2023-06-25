package com.prueba.backwebsimilar.service;

import com.baeldung.openapi.model.ProductDetail;
import com.prueba.backwebsimilar.ports.in.ProductServicePort;
import com.prueba.backwebsimilar.ports.out.ProductClientPort;
import com.prueba.backwebsimilar.services.ProductService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    public static final String PRODUCT_ID = "1";
    @Mock
    private ProductClientPort productClientPort;

    ProductDetail productDetail;

    private ProductServicePort service;

    @BeforeEach
    public void before() {
        service = new ProductService(productClientPort);
        productDetail = ProductDetail.builder()
                .id("2")
                .name("name")
                .availability(true)
                .price(BigDecimal.TEN)
                .build();
    }

    @Test
    @SneakyThrows
    void findPricesListByFullFilter() {
        var idsList = Set.of("2");
        given(productClientPort.getSimilarProducts(PRODUCT_ID)).willReturn(idsList);
        given(productClientPort.getProductDetail(anyString())).willReturn(productDetail);

        var response = service.getProductSimilar(PRODUCT_ID);
        assertNotNull(response);
        assertEquals(response.size(), 1);
    }
}
