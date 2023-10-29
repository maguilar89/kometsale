package com.kometsales.kometsalestest.infrastructure.persistence.adapter;

import com.kometsales.kometsalestest.domain.Customer;
import com.kometsales.kometsalestest.domain.port.CustomerRepository;
import com.kometsales.kometsalestest.infrastructure.persistence.exception.RecordNotFoundException;
import com.kometsales.kometsalestest.infrastructure.persistence.mapper.CustomerMapper;
import com.kometsales.kometsalestest.infrastructure.persistence.repository.CustomerJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerPersistence implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerMapper mapper;

    public CustomerPersistence(CustomerJpaRepository customerJpaRepository, CustomerMapper mapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Customer findById(Integer id) {
        return mapper.fromEntity(customerJpaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("There is no client with the entered ID, " + id)));
    }
}