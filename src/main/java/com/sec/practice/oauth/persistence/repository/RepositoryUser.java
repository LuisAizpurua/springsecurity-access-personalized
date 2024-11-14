package com.sec.practice.oauth.persistence.repository;

import com.sec.practice.oauth.persistence.entities.sec.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepositoryUser
       extends JpaRepository<User,Long> {

    @Query("select s from User s where s.username = ?0")
    Optional<User> findByUsername(String username);
}
