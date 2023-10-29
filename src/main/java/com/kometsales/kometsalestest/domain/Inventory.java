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
public class Inventory {

    private Integer id;
    private BigDecimal cubesPerCarrier;
    private BigDecimal basePrice;
    private Integer productId;
    private Integer companyId;
    private Integer boxTypeId;
    private Integer pack;

}