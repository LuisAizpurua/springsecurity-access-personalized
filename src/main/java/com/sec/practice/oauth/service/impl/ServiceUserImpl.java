package com.sec.practice.oauth.service.impl;

import java.util.List;

import com.sec.practice.oauth.exceptions.NotExistsEntity;
import com.sec.practice.oauth.exceptions.NotExists;
import com.sec.practice.oauth.persistence.entities.sec.User;
import com.sec.practice.oauth.persistence.repository.RepositoryUser;
import com.sec.practice.oauth.service.interfaces.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserImpl implements IServiceUser {

    @Autowired
    private RepositoryUser repositoryUser;

    @Override
    public User findById(Long id) {
        return repositoryUser.findById(id)
                .orElseThrow(()-> new NotExistsEntity().getMesg(id,User.class));
    }

    @Override
    public User findByUsername(String username) {
        return repositoryUser.findByUsername(username)
                .orElseThrow(() -> new NotExists(username));
    }

    @Override
    public List<User> findByAll() {
        return repositoryUser.findAll();
    }
}
