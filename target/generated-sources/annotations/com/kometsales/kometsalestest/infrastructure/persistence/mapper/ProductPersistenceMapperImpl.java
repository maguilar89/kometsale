package com.kometsales.kometsalestest.infrastructure.persistence.mapper;

import com.kometsales.kometsalestest.domain.Product;
import com.kometsales.kometsalestest.infrastructure.persistence.entity.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-28T17:48:55-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.19 (Amazon.com Inc.)"
)
@Component
public class ProductPersistenceMapperImpl implements ProductPersistenceMapper {

    @Override
    public Product fromEntity(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( productEntity.getName() );
        product.freshCutValue( productEntity.getFreshCutValue() );

        return product.build();
    }
}
