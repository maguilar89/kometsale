package com.kometsales.kometsalestest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private String name;
    private BigDecimal basePrice;
    private BigDecimal freshCutValue;
    private BigDecimal finalFreight;
    private String code;
    private String company;
    private BigDecimal price;

}