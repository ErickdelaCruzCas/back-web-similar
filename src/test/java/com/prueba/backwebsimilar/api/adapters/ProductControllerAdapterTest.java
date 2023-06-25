package com.prueba.backwebsimilar.api.adapters;

import com.baeldung.openapi.model.ProductDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.backwebsimilar.exception.CustomException;
import com.prueba.backwebsimilar.ports.in.ProductServicePort;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = {ProductControllerAdapter.class})
public class ProductControllerAdapterTest {

    public static final String PRODUCT_ID = "1";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductServicePort productServicePort;

    @Test
    @SneakyThrows
    void getProductSimilar() {
        var productDetail = ProductDetail.builder()
                .id("2")
                .name("name")
                .availability(true)
                .price(BigDecimal.TEN)
                .build();
        var productDetailSet = Set.of(productDetail);
        when(productServicePort.getProductSimilar(anyString())).thenReturn(productDetailSet);
        mockMvc.perform(get("/product/{productId}/similar", PRODUCT_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is("2")));
        verify(productServicePort, times(1)).getProductSimilar(PRODUCT_ID);
    }

}
