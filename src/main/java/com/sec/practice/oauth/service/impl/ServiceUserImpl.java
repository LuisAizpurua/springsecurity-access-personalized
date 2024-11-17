package com.sec.practice.oauth.service.impl;

import java.util.List;

import com.sec.practice.oauth.exceptions.NotExistUser;
import com.sec.practice.oauth.exceptions.NotExistUsername;
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
                .orElseThrow(()-> new NotExistUser().getMessageException());
    }

    @Override
    public User findByUsername(String username) {
        return repositoryUser.findByUsername(username)
                .orElseThrow(() -> new NotExistUsername().getMessageException(username));
    }

    @Override
    public List<User> findByAll() {
        return repositoryUser.findAll();
    }
}
