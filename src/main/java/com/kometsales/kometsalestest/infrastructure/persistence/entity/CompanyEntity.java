package com.kometsales.kometsalestest.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblcompanypt")
@Entity
public class CompanyEntity {

    @Id
    private Integer id;
    @Column(name = "name")
    private String name;

}