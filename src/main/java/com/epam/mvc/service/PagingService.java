package com.epam.mvc.service;

import com.epam.mvc.dto.Product;

import java.util.List;

public interface PagingService {

    void setPage(int page);

    void setPageSize(int pageSize);

    List<Product> getPageList();

    int getPageCount();

    void setCurrentPage(int page);
}
