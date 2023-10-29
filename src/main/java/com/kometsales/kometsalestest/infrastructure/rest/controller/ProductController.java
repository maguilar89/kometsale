package com.kometsales.kometsalestest.infrastructure.rest.controller;

import com.kometsales.kometsalestest.application.search.ProductSearch;
import com.kometsales.kometsalestest.infrastructure.rest.mapper.ProductMapper;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductRespondWithCompany;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductRespondWithPrice;
import com.kometsales.kometsalestest.infrastructure.rest.response.ProductResponseFinalFreight;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("kometsale")
public class ProductController {

    private final ProductSearch productSearch;
    private final ProductMapper mapper;

    public ProductController(ProductSearch productSearch, ProductMapper mapper) {
        this.productSearch = productSearch;
        this.mapper = mapper;
    }

    @GetMapping("/products")
    public List<ProductRespondWithCompany> findProductWithCompany(@RequestParam Integer companyId) {

        return productSearch.findByCompanyId(companyId)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/products-price")
    public List<ProductRespondWithPrice> findProductByCustomerId(@RequestParam Integer customerId) {
        return productSearch.findByCustomerId(customerId)
                .stream()
                .map(mapper::toResponseCompany)
                .collect(Collectors.toList());
    }

    @GetMapping("/products-final-freight")
    public List<ProductResponseFinalFreight> findByCompanyId(@RequestParam Integer companyId) {
        return productSearch.findProductByCompanyId(companyId)
                .stream()
                .map(mapper::toResponseFinalFreight)
                .collect(Collectors.toList());
    }


}