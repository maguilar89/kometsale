package com.kometsales.kometsalestest.infrastructure.persistence.repository;

import com.kometsales.kometsalestest.infrastructure.persistence.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, Integer> {

    @Query(value = "SELECT pd.name as product, cp.name as company, iv.basePrice as basePrice " +
            "FROM ProductEntity pd " +
            "INNER JOIN InventoryEntity iv on iv.productId = pd.id " +
            "INNER JOIN CompanyEntity cp on iv.productId = cp.id ")
    List<Map<String, Object>> findAllResult();

    @Query(value = "SELECT pd.name as product, cp.name as company, iv.basePrice as basePrice, " +
            "bt.width as width, bt.height as height, bt.length as length, iv.cubesPerCarrier as cubesPerCarrier, " +
            "iv.pack as pack, pd.freshCutValue as freshCutValue  " +
            "FROM ProductEntity pd " +
            "INNER JOIN InventoryEntity iv on iv.productId = pd.id " +
            "INNER JOIN CompanyEntity cp on iv.productId = cp.id "+
            "INNER JOIN BoxTypeEntity bt on iv.boxTypeId = bt.id " +
            "WHERE iv.companyId = :companyId")
    List<Map<String, Object>> findAllResultWithBoxType(@Param("companyId") Integer companyId);


}
