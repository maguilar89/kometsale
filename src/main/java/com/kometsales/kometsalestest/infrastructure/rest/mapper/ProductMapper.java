package com.kometsales.kometsalestest.infrastructure.rest.mapper;

import com.kometsales.kometsalestest.domain.Product;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductRespondWithCompany;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductRespondWithPrice;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductResponseFinalFreight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.math.BigDecimal;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    @Mapping(target = "productName", expression = "java(product.getName())")
    @Mapping(target = "productCode", expression = "java(product.getCode())")
    ProductRespondWithCompany toResponse(Product product);

    @Mapping(target = "productName", expression = "java(product.getName())")
    @Mapping(target = "companyName", expression = "java(product.getCompany())")
    @Mapping(target = "price", expression = "java(product.getPrice())")
    ProductRespondWithPrice toResponseCompany(Product product);

    @Mapping(target = "productName", expression = "java(product.getName())")
    @Mapping(target = "basePrice", expression = "java(product.getBasePrice())")
    @Mapping(target = "finalFreight", expression = "java(product.getFinalFreight())")
    ProductResponseFinalFreight toResponseFinalFreight(Product product);

}