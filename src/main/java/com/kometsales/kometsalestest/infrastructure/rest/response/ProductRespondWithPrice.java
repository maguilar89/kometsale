package com.kometsales.kometsalestest.infrastructure.rest.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRespondWithPrice {

    private String productName;
    private String companyName;
    private BigDecimal price;

}