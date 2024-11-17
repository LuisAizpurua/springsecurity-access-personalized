package com.sec.practice.oauth.persistence.repository.entities;

import com.sec.practice.oauth.persistence.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCategory
   extends JpaRepository<Category, Long> {
}
