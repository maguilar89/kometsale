package com.kometsales.kometsalestest.infrastructure.persistence.mapper;

import com.kometsales.kometsalestest.domain.Product;
import com.kometsales.kometsalestest.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductPersistenceMapper {


    @Mapping(target = "name", expression = "java(productEntity.getName())")
    @Mapping(target = "freshCutValue", expression = "java(productEntity.getFreshCutValue())")
    Product fromEntity(ProductEntity productEntity);

}