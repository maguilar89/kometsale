package com.kometsales.kometsalestest.infrastructure.persistence.mapper;

import com.kometsales.kometsalestest.domain.Inventory;
import com.kometsales.kometsalestest.infrastructure.persistence.entity.InventoryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-28T17:48:56-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.19 (Amazon.com Inc.)"
)
@Component
public class InventoryPersistenceMapperImpl implements InventoryPersistenceMapper {

    @Override
    public Inventory fromEntity(InventoryEntity inventoryEntity) {
        if ( inventoryEntity == null ) {
            return null;
        }

        Inventory.InventoryBuilder inventory = Inventory.builder();

        inventory.id( inventoryEntity.getId() );
        inventory.cubesPerCarrier( inventoryEntity.getCubesPerCarrier() );
        inventory.basePrice( inventoryEntity.getBasePrice() );
        inventory.productId( inventoryEntity.getProductId() );
        inventory.companyId( inventoryEntity.getCompanyId() );
        inventory.boxTypeId( inventoryEntity.getBoxTypeId() );
        inventory.pack( inventoryEntity.getPack() );

        return inventory.build();
    }
}
