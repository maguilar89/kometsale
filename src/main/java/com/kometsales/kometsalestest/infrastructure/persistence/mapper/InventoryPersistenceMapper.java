package com.kometsales.kometsalestest.infrastructure.persistence.mapper;

import com.kometsales.kometsalestest.domain.Inventory;
import com.kometsales.kometsalestest.infrastructure.persistence.entity.InventoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface InventoryPersistenceMapper {


    Inventory fromEntity(InventoryEntity inventoryEntity);

}
