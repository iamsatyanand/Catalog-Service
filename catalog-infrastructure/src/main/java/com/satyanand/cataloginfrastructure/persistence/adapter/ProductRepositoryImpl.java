package com.satyanand.cataloginfrastructure.persistence.adapter;

import com.satyanand.catalogdomain.model.Product;
import com.satyanand.catalogdomain.repository.ProductRepository;
import com.satyanand.cataloginfrastructure.persistence.entity.ProductEntity;
import com.satyanand.cataloginfrastructure.persistence.mapper.ProductMapper;
import com.satyanand.cataloginfrastructure.persistence.repository.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaRepository;

    @Override
    public Product save(Product product) {
        var entity = ProductMapper.toEntity(product);
        var saved = jpaRepository.save(entity);
        return ProductMapper.toDomain(saved);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id)
                .map(ProductMapper::toDomain);
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        return jpaRepository.findByCategoryId(categoryId)
                .stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
