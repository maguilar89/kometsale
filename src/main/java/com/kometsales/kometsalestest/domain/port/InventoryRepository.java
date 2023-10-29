package com.kometsales.kometsalestest.domain.port;

import java.util.List;
import java.util.Map;

public interface InventoryRepository {

    List<Map<String, Object>> findAllResult();

    List<Map<String, Object>> findAllResultWithBoxType(Integer companyId);

}