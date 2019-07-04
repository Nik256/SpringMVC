package com.epam.mvc.service;

import com.epam.mvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CustomPagingService implements PagingService {

    @Autowired
    private ProductService productService;

    private PagedListHolder<Product> pagedListHolder;

    @Value("${pagingSize}")
    private int pagingSize;

    @PostConstruct
    private void init() {
        pagedListHolder = new PagedListHolder<>(productService.getAllProduct());
        setPageSize(pagingSize);
    }

    @Override
    public void setPage(int page) {
        pagedListHolder.setPage(page);
    }

    @Override
    public void setPageSize(int pageSize) {
        pagedListHolder.setPageSize(pageSize);
    }

    @Override
    public List<Product> getPageList() {
        return pagedListHolder.getPageList();
    }

    @Override
    public int getPageCount() {
        return pagedListHolder.getPageCount();
    }

    @Override
    public void setCurrentPage(int page) {
        if (page < 1 || page > getPageCount()) {
            setPage(0);
        } else {
            setPage(page - 1);
        }
    }
}
