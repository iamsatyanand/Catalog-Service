package com.satyanand.catalogdomain.repository;

import com.satyanand.catalogdomain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findAll();

    void deleteById(Long id);

}
