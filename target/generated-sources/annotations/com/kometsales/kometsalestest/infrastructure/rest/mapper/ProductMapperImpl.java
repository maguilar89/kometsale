package com.kometsales.kometsalestest.infrastructure.rest.mapper;

import com.kometsales.kometsalestest.domain.Product;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductRespondWithCompany;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductRespondWithPrice;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductResponseFinalFreight;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-28T17:48:56-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.19 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductRespondWithCompany toResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductRespondWithCompany productRespondWithCompany = new ProductRespondWithCompany();

        productRespondWithCompany.setProductName( product.getName() );
        productRespondWithCompany.setProductCode( product.getCode() );

        return productRespondWithCompany;
    }

    @Override
    public ProductRespondWithPrice toResponseCompany(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductRespondWithPrice productRespondWithPrice = new ProductRespondWithPrice();

        productRespondWithPrice.setProductName( product.getName() );
        productRespondWithPrice.setCompanyName( product.getCompany() );
        productRespondWithPrice.setPrice( product.getPrice() );

        return productRespondWithPrice;
    }

    @Override
    public ProductResponseFinalFreight toResponseFinalFreight(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseFinalFreight productResponseFinalFreight = new ProductResponseFinalFreight();

        productResponseFinalFreight.setProductName( product.getName() );
        productResponseFinalFreight.setBasePrice( product.getBasePrice() );
        productResponseFinalFreight.setFinalFreight( product.getFinalFreight() );

        return productResponseFinalFreight;
    }
}
