package com.kometsales.kometsalestest.infrastructure.persistence.repository;

import com.kometsales.kometsalestest.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {


}