package com.satyanand.cataloginfrastructure.persistence.repository;

import com.satyanand.cataloginfrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
