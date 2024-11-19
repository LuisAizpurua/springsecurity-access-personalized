package com.sec.practice.oauth.service.impl;

import com.sec.practice.oauth.exceptions.NotExistsEntity;
import com.sec.practice.oauth.persistence.entities.Category;
import com.sec.practice.oauth.persistence.repository.entities.RepositoryInventory;
import com.sec.practice.oauth.service.interfaces.IServiceInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("serviceCategory")
public class ServiceCategoryImpl implements IServiceInventory<Category> {

    @Autowired
    private RepositoryInventory<Category> repositoryCategory;

    @Override
    public Page<Category> findAll(Pageable page) {
        return repositoryCategory.findAll(page);
    }

    @Override
    public Category findById(Long id) {
        return repositoryCategory.findById(id)
                .orElseThrow(()-> new NotExistsEntity().getMesg(id, Category.class));
    }

    @Override
    public Category remove(Long id) {
        return Optional.ofNullable(repositoryCategory.findById(id))
                .map(Optional::get)
                .map(category-> {
                    repositoryCategory.delete(category);
                    return category;
                })
                .orElseThrow(()-> new NotExistsEntity().getMesg(id, Category.class));
    }

    @Override
    public Category update(Category object) {
        return Optional.ofNullable(repositoryCategory.save(object))
                .orElseThrow(()-> new RuntimeException("Failed to update entity category"));
    }

    @Override
    public Category save(Category object) {
        return Optional.ofNullable(repositoryCategory.save(object))
                .orElseThrow(()-> new RuntimeException("Failed to save entity category"));
    }
}
