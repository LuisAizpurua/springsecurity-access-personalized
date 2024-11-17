package com.sec.practice.oauth.persistence.repository.entities;

import com.sec.practice.oauth.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduct
      extends JpaRepository<Product, Long> {

}
