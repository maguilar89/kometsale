package com.kometsales.kometsalestest.infrastructure.rest.controller;

import com.kometsales.kometsalestest.application.search.ProductSearch;
import com.kometsales.kometsalestest.domain.Product;
import com.kometsales.kometsalestest.infrastructure.rest.mapper.ProductMapper;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductRespondWithPrice;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductResponseFinalFreight;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private static final String KOMETSALE_PATH = "/kometsale";

    @Mock
    private ProductSearch productSearch;

    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private ProductController productController;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .build();
    }

    @Test
    void whenFindByCompanyId_ThenReturnListResult() throws Exception {
        EasyRandom easyRandom = new EasyRandom();
        List<ProductResponseFinalFreight> productRespondWithCompanies =
                easyRandom.objects(ProductResponseFinalFreight.class, 3)
                        .collect(Collectors.toList());

        List<Product> responses = easyRandom.objects(Product.class, 3)
                .collect(Collectors.toList());

        Mockito.lenient().when(productSearch.findByCustomerId(any())).thenReturn(responses);

        this.mockMvc.perform(get(KOMETSALE_PATH+"/products-final-freight")
                        .param("companyId", "123"))
                .andExpect(status().isOk());
    }

    @Test
    void whenFindByCompanyId_WithoutParameter_ThenReturnBadRequest() throws Exception {
        EasyRandom easyRandom = new EasyRandom();
        List<ProductResponseFinalFreight> productRespondWithCompanies =
                easyRandom.objects(ProductResponseFinalFreight.class, 3)
                .collect(Collectors.toList());

        List<Product> responses = easyRandom.objects(Product.class, 3)
                .collect(Collectors.toList());

        Mockito.lenient().when(productSearch.findByCustomerId(any())).thenReturn(responses);
        this.mockMvc.perform(get(KOMETSALE_PATH+"/products-final-freight"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenFindProductByCustomerId_ThenReturnListResult() throws Exception {
        EasyRandom easyRandom = new EasyRandom();
        List<ProductResponseFinalFreight> productRespondWithCompanies =
                easyRandom.objects(ProductResponseFinalFreight.class, 3)
                        .collect(Collectors.toList());

        List<Product> responses = easyRandom.objects(Product.class, 3)
                .collect(Collectors.toList());

        Mockito.lenient().when(productSearch.findByCustomerId(any())).thenReturn(responses);

        this.mockMvc.perform(get(KOMETSALE_PATH+"/products-price")
                        .param("customerId", "123"))
                .andExpect(status().isOk());
    }

    @Test
    void whenFindProductByCustomerId_WithoutParameter_ThenReturnBadRequest() throws Exception {
        EasyRandom easyRandom = new EasyRandom();
        List<ProductRespondWithPrice> productRespondWithCompanies =
                easyRandom.objects(ProductRespondWithPrice.class, 3)
                        .collect(Collectors.toList());

        List<Product> responses = easyRandom.objects(Product.class, 3)
                .collect(Collectors.toList());

        Mockito.lenient().when(productSearch.findByCustomerId(any())).thenReturn(responses);
        this.mockMvc.perform(get(KOMETSALE_PATH+"/products-price"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenFindProductWithCompany_ThenReturnListResult() throws Exception {
        EasyRandom easyRandom = new EasyRandom();
        List<ProductResponseFinalFreight> productRespondWithCompanies =
                easyRandom.objects(ProductResponseFinalFreight.class, 3)
                        .collect(Collectors.toList());

        List<Product> responses = easyRandom.objects(Product.class, 3)
                .collect(Collectors.toList());

        Mockito.lenient().when(productSearch.findByCustomerId(any())).thenReturn(responses);

        this.mockMvc.perform(get(KOMETSALE_PATH+"/products")
                        .param("companyId", "123"))
                .andExpect(status().isOk());
    }

    @Test
    void whenFindProductWithCompany_WithoutParameter_ThenReturnBadRequest() throws Exception {
        EasyRandom easyRandom = new EasyRandom();
        List<ProductRespondWithPrice> productRespondWithCompanies =
                easyRandom.objects(ProductRespondWithPrice.class, 3)
                        .collect(Collectors.toList());

        List<Product> responses = easyRandom.objects(Product.class, 3)
                .collect(Collectors.toList());

        Mockito.lenient().when(productSearch.findByCustomerId(any())).thenReturn(responses);
        this.mockMvc.perform(get(KOMETSALE_PATH+"/products"))
                .andExpect(status().isBadRequest());
    }

}
