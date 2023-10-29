package com.kometsales.kometsalestest.infrastructure.persistence.adapter;

import com.kometsales.kometsalestest.domain.Product;
import com.kometsales.kometsalestest.domain.port.ProductRepository;
import com.kometsales.kometsalestest.infrastructure.persistence.mapper.ProductPersistenceMapper;
import com.kometsales.kometsalestest.infrastructure.persistence.repository.ProductJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductPersistence implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductPersistenceMapper mapper;

    public ProductPersistence(ProductJpaRepository productJpaRepository, ProductPersistenceMapper mapper) {
        this.productJpaRepository = productJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> findByCompanyId(Integer companyId) {
        return productJpaRepository.findProductByCompanyId(companyId)
                .stream()
                .map(mapper::fromEntity)
                .collect(Collectors.toList());
    }

}