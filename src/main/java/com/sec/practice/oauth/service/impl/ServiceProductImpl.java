package com.sec.practice.oauth.service.impl;

import com.sec.practice.oauth.exceptions.NotExistsEntity;
import com.sec.practice.oauth.persistence.entities.Product;
import com.sec.practice.oauth.persistence.repository.entities.RepositoryInventory;
import com.sec.practice.oauth.service.interfaces.IServiceInventory;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("serviceProduct")
@Primary
public class ServiceProductImpl implements IServiceInventory<Product> {

    @Autowired
    private RepositoryInventory<Product> repositoryProduct;

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
       return Optional.ofNullable(repositoryProduct.findById(id))
                .map(Optional::get)
                .map(producto-> {
                    repositoryProduct.delete(producto);
                    return producto;
                })
                .orElseThrow(()-> new NotExistsEntity().getMesg(id, Product.class));
    }

    @Override
    public Product update(Product product) {
        return Optional.ofNullable(repositoryProduct.save(product))
                .orElseThrow(()-> new RuntimeException("Failed to update entity product"));
    }

    @Override
    public Product save(Product product) {
        return Optional.ofNullable(repositoryProduct.save(product))
                .orElseThrow(()-> new RuntimeException("Failed to update entity product"));
    }
}
