package com.sec.practice.oauth.service.interfaces;

import com.sec.practice.oauth.persistence.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceProduct {

    Page<Product> findAll(Pageable page);

    Product findById(Long id);

    Product remove(Long id);

    Product update(Product product);
}
