package com.kometsales.kometsalestest.infrastructure.persistence.entity.compositekey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryEntityKey implements Serializable {

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "companyid")
    private Integer companyId;

    @Column(name = "boxtypeid")
    private Integer boxTypeId;

}