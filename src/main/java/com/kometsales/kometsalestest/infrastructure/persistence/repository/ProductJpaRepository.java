package com.kometsales.kometsalestest.infrastructure.persistence.repository;

import com.kometsales.kometsalestest.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "SELECT pd " +
            "FROM ProductEntity pd " +
            "INNER JOIN InventoryEntity iv on iv.productId = pd.id " +
            "WHERE iv.companyId = :companyId")
    List<ProductEntity> findProductByCompanyId(@Param("companyId") Integer companyId);

}