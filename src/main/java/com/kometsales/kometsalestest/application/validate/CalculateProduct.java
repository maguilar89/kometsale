package com.kometsales.kometsalestest.application.validate;

import com.kometsales.kometsalestest.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CalculateProduct {

    String calculate(String productName);

    BigDecimal calculatePrice(String basePriceString, BigDecimal markDown);

    List<Product> calculateFinalFreight(List<Map<String, Object>> inventories);

}