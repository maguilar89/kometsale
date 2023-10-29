package com.kometsales.kometsalestest.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
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
@Table(name = "tblboxtypept")
@Entity
public class BoxTypeEntity {

    @Id
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "width")
    private BigDecimal width;
    @Column(name = "height")
    private BigDecimal height;
    @Column(name = "length")
    private BigDecimal length;
}
