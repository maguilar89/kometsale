package com.kometsales.kometsalestest.infrastructure.persistence.entity;

import com.kometsales.kometsalestest.infrastructure.persistence.entity.compositekey.InventoryEntityKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblinventorypt")
@Entity
@IdClass(InventoryEntityKey.class)
public class InventoryEntity {

    @Id
    private Integer id;
    @Column(name = "cubespercarrier")
    private BigDecimal cubesPerCarrier;
    @Column(name = "baseprice")
    private BigDecimal basePrice;
    @Column(name = "productid")
    private Integer productId;
    @Column(name = "companyid")
    private Integer companyId;
    @Column(name = "boxtypeid")
    private Integer boxTypeId;
    @Column(name = "pack")
    private Integer pack;

}