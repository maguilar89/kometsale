package com.kometsales.kometsalestest.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblcustomerpt")
@Entity
@Builder
public class CustomerEntity {

    @Id
    private Integer id;
    private String name;
    @Column(name="markdown")
    private BigDecimal marDown;

}