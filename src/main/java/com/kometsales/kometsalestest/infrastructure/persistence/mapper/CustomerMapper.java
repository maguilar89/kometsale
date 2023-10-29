package com.kometsales.kometsalestest.infrastructure.persistence.mapper;

import com.kometsales.kometsalestest.domain.Customer;
import com.kometsales.kometsalestest.infrastructure.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CustomerMapper {

    @Mapping(target = "markDown", expression = "java(customerEntity.getMarDown())")
    Customer fromEntity(CustomerEntity customerEntity);

}