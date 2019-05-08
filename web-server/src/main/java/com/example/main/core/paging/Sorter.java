package com.example.main.core.paging;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

//排序封装
@Component
public class Sorter {
    public Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }

    public Sort basicSort(SortEntity... dtos) {
        Sort result = null;
        for (int i = 0; i < dtos.length; i++) {
            SortEntity dto = dtos[i];
            if (result == null) {
                result = new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField());
            } else {
                result = result.and(new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField()));
            }
        }
        return result;
    }
}
