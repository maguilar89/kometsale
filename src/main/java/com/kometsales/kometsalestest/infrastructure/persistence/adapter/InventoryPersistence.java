package com.kometsales.kometsalestest.infrastructure.persistence.adapter;

import com.kometsales.kometsalestest.domain.port.InventoryRepository;
import com.kometsales.kometsalestest.infrastructure.persistence.repository.InventoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class InventoryPersistence implements InventoryRepository {

    private final InventoryJpaRepository inventoryJpaRepository;

    public InventoryPersistence(InventoryJpaRepository inventoryJpaRepository) {
        this.inventoryJpaRepository = inventoryJpaRepository;
    }

    @Override
    public List<Map<String, Object>> findAllResult() {
        return inventoryJpaRepository.findAllResult();
    }

    @Override
    public List<Map<String, Object>> findAllResultWithBoxType(Integer companyId) {
        return inventoryJpaRepository.findAllResultWithBoxType(companyId);
    }
}
