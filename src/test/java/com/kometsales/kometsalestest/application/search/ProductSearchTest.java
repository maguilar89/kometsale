package com.kometsales.kometsalestest.application.search;

import com.kometsales.kometsalestest.application.validate.impl.CalculateProductCode;
import com.kometsales.kometsalestest.domain.Customer;
import com.kometsales.kometsalestest.domain.Product;
import com.kometsales.kometsalestest.domain.port.ProductRepository;
import com.kometsales.kometsalestest.infrastructure.persistence.adapter.CustomerPersistence;
import com.kometsales.kometsalestest.infrastructure.persistence.adapter.InventoryPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductSearchTest {

    @Mock
    private ProductRepository productRepository;
    @Spy
    private CalculateProductCode calculateProductCode;
    @Mock
    private CustomerPersistence customerPersistence;
    @Mock
    private InventoryPersistence inventoryPersistence;

    @InjectMocks
    private ProductSearch productSearch;


    @Test
    void whenFindProduct_GivenValidParameters_ThenReturnListResult() {
        Integer companyId = 12;

        Product product = buildWhiteProduct();
        Mockito.when(productRepository.findByCompanyId(any()))
                .thenReturn(List.of(product));

        List<Product> result = productSearch.findByCompanyId(companyId);

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void whenFindByCompanyId_GivenValidParametersWhite_henReturnIsOk() {

        Integer companyId = 12;
        String expectedValue = "&4e-p1m-33h";

        Product product = buildWhiteProduct();
        Mockito.when(productRepository.findByCompanyId(any()))
                .thenReturn(List.of(product));

        List<Product> result = productSearch.findByCompanyId(companyId);

        Assertions.assertEquals(expectedValue,result.get(0).getCode());
    }

    @Test
    void whenFindByCompanyId_GivenNotValidParametersWhite_henReturnIsNotOk() {

        Integer companyId = 12;
        String expectedValue = "&4e-p0m-33h";

        Product product = buildWhiteProduct();
        Mockito.when(productRepository.findByCompanyId(any()))
                .thenReturn(List.of(product));

        List<Product> result = productSearch.findByCompanyId(companyId);

        Assertions.assertNotEquals(expectedValue,result.get(0).getCode());
    }

    @Test
    void whenFindByCompanyId_GivenNotValidParametersRedProduct_ThenReturnIsNotOk() {

        Integer companyId = 12;
        String expectedValue = "R1d-R3s-21m";

        Product product = buildRedProduct();
        Mockito.when(productRepository.findByCompanyId(any()))
                .thenReturn(List.of(product));

        List<Product> result = productSearch.findByCompanyId(companyId);

        Assertions.assertNotEquals(expectedValue,result.get(0).getCode());
    }

    @Test
    void whenFindByCompanyId_GivenValidParametersRedProduct_ThenReturnIsOk() {

        Integer companyId = 12;
        String expectedValue = "R1d-R3s-22m";

        Product product = buildRedProduct();
        Mockito.when(productRepository.findByCompanyId(any()))
                .thenReturn(List.of(product));

        List<Product> result = productSearch.findByCompanyId(companyId);

        Assertions.assertEquals(expectedValue,result.get(0).getCode());
    }

    @Test
    void whenFindByCompanyId_GivenNotValidParametersRedProduct_ThenReturnIsNotOx() {

        Integer companyId = 12;
        String expectedValue = "R1d-R3s-21m";

        Product product = buildRedProduct();
        Mockito.when(productRepository.findByCompanyId(any()))
                .thenReturn(List.of(product));

        List<Product> result = productSearch.findByCompanyId(companyId);

        Assertions.assertNotEquals(expectedValue,result.get(0).getCode());
    }

    @Test
    void whenFindByCustomerId_GivenValidParameters_ThenReturnListResult() {

        BigDecimal expectedPrice =  new BigDecimal("1.6150000");
        Integer customerId = 12;

        Customer product = buildCustomer();
        Mockito.when(customerPersistence.findById(any()))
                .thenReturn(product);

        Mockito.when(inventoryPersistence.findAllResult()).thenReturn(getInventories());

        List<Product> products = productSearch.findByCustomerId(customerId);

        Assertions.assertEquals(expectedPrice,products.get(0).getPrice());
    }

    @Test
    void whenFindByCustomerId_GivenValidParameters_ThenReturnListResultIsOk() {

        Integer customerId = 12;

        BigDecimal expectedFinalFreight = new BigDecimal("1.9635342222222225120000");

        Mockito.when(inventoryPersistence.findAllResultWithBoxType(any())).thenReturn(getInventoriesWithBoxType());

        List<Product> products = productSearch.findProductByCompanyId(customerId);

        Assertions.assertEquals(expectedFinalFreight,products.get(0).getFinalFreight());
    }

    private Product buildWhiteProduct() {
        return Product
                .builder()
                .name("&White pom 3Inch")
                .build();
    }

    private Product buildRedProduct() {
        return Product
                .builder()
                .name("Red Roses 23cm")
                .build();
    }

    private Customer buildCustomer() {
        return Customer
                .builder()
                .name("Luis")
                .markDown(new BigDecimal("5.0"))
                .build();
    }

    private List<Map<String, Object>> getInventories(){
        Map<String,Object> values = new HashMap<>();
        values.put("product","Red Roses 23cm");
        values.put("company","BellaFlowers");
        values.put("basePrice",new BigDecimal("1.70000"));
        return List.of(values);
    }

    private Customer buildCustomerForSecondTest() {
        return Customer
                .builder()
                .name("Luis")
                .markDown(new BigDecimal("5.0"))
                .build();
    }

    private List<Map<String, Object>> getInventoriesWithBoxType(){
        Map<String,Object> values = new HashMap<>();
        values.put("width","12.10000");
        values.put("height","12.80000");
        values.put("length","11.20000");
        values.put("product","&White pom 3Inch");
        values.put("company","BeautiFlowers");
        values.put("basePrice",new BigDecimal("1.10000"));
        values.put("pack","1");
        values.put("cubesPerCarrier","16.30000");
        values.put("freshCutValue","12.00");
        return List.of(values);
    }

    /*
    SELECT pd.name as product, cp.name as company, iv.basePrice as basePrice, " +
            "bt.width as width, bt.height as height, bt.length as length, iv.cubesPerCarrier as cubesPerCarrier, " +
            "iv.pack as pack, pd.freshCutValue as freshCutValue  " +
     */

}