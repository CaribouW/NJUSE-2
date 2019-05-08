package com.example.main.core.paging;

import com.example.main.core.enums.SortEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PageableUtil {
    @Autowired
    private Sorter sorter;

    /**
     * 获取基础分页对象
     *
     * @param page 获取第几页
     * @param size 每页条数
     * @param dtos 排序对象数组
     * @return
     */
    public Pageable basicPage(Integer page, Integer size, SortEntity... dtos) {
        Sort sort = sorter.basicSort(dtos);
        page = (page == null || page < 0) ? 0 : page;
        size = (size == null || size <= 0) ? 15 : size;
        Pageable pageable = PageRequest.of(page, size, sort);
        return pageable;
    }

    /**
     * 获取基础分页对象，每页条数默认15条
     * - 默认以id降序排序
     *
     * @param page 获取第几页
     * @return
     */
    public Pageable basicPage(Integer page) {
        return basicPage(page, 0, new SortEntity("desc", "id"));
    }

    /**
     * 获取基础分页对象，排序方式默认降序
     *
     * @param page       获取第几页
     * @param size       每页条数
     * @param orderField 排序字段
     * @return
     */
    public Pageable basicPage(Integer page, Integer size, String orderField) {
        return basicPage(page, size, new SortEntity(SortEnum.DESC.getVal(), orderField));
    }

    /**
     * 获取基础分页对象
     * - 每页条数默认15条
     * - 排序方式默认降序
     *
     * @param page       获取第几页
     * @param orderField 排序字段
     * @return
     */
    public Pageable basicPage(Integer page, String orderField) {
        return basicPage(page, 0, new SortEntity(SortEnum.DESC.getVal(), orderField));
    }
}
