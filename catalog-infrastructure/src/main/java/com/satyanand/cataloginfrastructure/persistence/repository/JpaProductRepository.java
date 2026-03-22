package com.satyanand.cataloginfrastructure.persistence.repository;

import com.satyanand.cataloginfrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategoryId(Long categoryId);
}
