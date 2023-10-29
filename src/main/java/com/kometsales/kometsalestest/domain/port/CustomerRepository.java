package com.kometsales.kometsalestest.domain.port;

import com.kometsales.kometsalestest.domain.Customer;

public interface CustomerRepository {

    Customer findById(Integer id);

}