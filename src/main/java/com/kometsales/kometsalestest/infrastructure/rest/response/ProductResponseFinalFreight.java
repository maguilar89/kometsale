package com.kometsales.kometsalestest.infrastructure.rest.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseFinalFreight {

    private String productName;
    private BigDecimal basePrice;
    private BigDecimal finalFreight;

}