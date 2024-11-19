package com.sec.practice.oauth.persistence.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInventory<T>
      extends JpaRepository<T, Long> {

}
