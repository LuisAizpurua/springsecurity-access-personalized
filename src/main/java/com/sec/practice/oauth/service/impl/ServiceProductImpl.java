package com.sec.practice.oauth.service.impl;

import com.sec.practice.oauth.exceptions.NotExistsEntity;
import com.sec.practice.oauth.persistence.entities.Product;
import com.sec.practice.oauth.persistence.repository.entities.RepositoryProduct;
import com.sec.practice.oauth.service.interfaces.IServiceProduct;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceProductImpl implements IServiceProduct {

    @Autowired
    private RepositoryProduct repositoryProduct;

    @Override
    public Page<Product> findAll(Pageable page) {
        return repositoryProduct.findAll(page);
    }

    @Override
    public Product findById(Long id) {
        return repositoryProduct.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, Product.class.getName()));
    }

    @Override
    public Product remove(Long id) {
        Product prod = repositoryProduct.findById(id)
                .orElseThrow(() ->  new NotExistsEntity().getMesg(id, Product.class));
        repositoryProduct.delete(prod);
        return prod;
    }

    @Override
    public Product update(Product product) {
        return repositoryProduct.save(product);
    }
}
