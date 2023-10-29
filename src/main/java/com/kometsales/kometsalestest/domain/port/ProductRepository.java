package com.kometsales.kometsalestest.domain.port;

import com.kometsales.kometsalestest.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findByCompanyId(Integer companyId);

}