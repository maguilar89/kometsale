package com.kometsales.kometsalestest.infrastructure.persistence.mapper;

import com.kometsales.kometsalestest.domain.Customer;
import com.kometsales.kometsalestest.infrastructure.persistence.entity.CustomerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-28T17:48:56-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.19 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer fromEntity(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.name( customerEntity.getName() );

        customer.markDown( customerEntity.getMarDown() );

        return customer.build();
    }
}
