package com.sec.practice.oauth.service;

import com.sec.practice.oauth.persistence.entities.sec.User;

import java.util.List;

public interface IServiceUser {

    User findById(Long id);
    User findByUsername(String username);

    List<User> findByAll();
}
