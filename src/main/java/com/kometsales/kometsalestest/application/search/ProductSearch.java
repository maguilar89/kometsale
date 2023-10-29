package com.kometsales.kometsalestest.application.search;

import com.kometsales.kometsalestest.application.validate.impl.CalculateProductCode;
import com.kometsales.kometsalestest.domain.Product;
import com.kometsales.kometsalestest.domain.port.ProductRepository;
import com.kometsales.kometsalestest.infrastructure.persistence.adapter.CustomerPersistence;
import com.kometsales.kometsalestest.infrastructure.persistence.adapter.InventoryPersistence;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductSearch {

    private final ProductRepository productRepository;
    private final CalculateProductCode calculateProductCode;
    private final CustomerPersistence customerPersistence;
    private final InventoryPersistence inventoryPersistence;

    public ProductSearch(ProductRepository productRepository,
                         CalculateProductCode calculateProductCode,
                         CustomerPersistence customerPersistence, InventoryPersistence inventoryPersistence) {
        this.productRepository = productRepository;
        this.calculateProductCode = calculateProductCode;
        this.customerPersistence = customerPersistence;
        this.inventoryPersistence = inventoryPersistence;
    }

    public List<Product> findByCompanyId(Integer companyId) {
        return productRepository.findByCompanyId(companyId)
                .stream()
                .map(product -> Product
                        .builder()
                        .name(product.getName())
                        .code(calculateProductCode.calculate(product.getName()))
                        .build()).collect(Collectors.toList());
    }

    @Transactional
    public List<Product> findByCustomerId(Integer customerId) {

        BigDecimal markDown = customerPersistence.findById(customerId).getMarkDown();

        List<Map<String, Object>> inventories = inventoryPersistence.findAllResult();

        return inventories
                .stream()
                .map(result -> Product
                        .builder()
                        .name(result.get("product").toString())
                        .company(result.get("company").toString())
                        .price(calculateProductCode.calculatePrice(result.get("basePrice").toString(), markDown))
                        .build()).collect(Collectors.toList());
    }

    @Transactional
    public List<Product> findProductByCompanyId(Integer companyId) {
        List<Map<String, Object>> inventories = inventoryPersistence.findAllResultWithBoxType(companyId);
        return calculateProductCode.calculateFinalFreight(inventories);
    }

}