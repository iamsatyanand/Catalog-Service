package com.satyanand.cataloginfrastructure.persistence.mapper;

import com.satyanand.catalogdomain.model.Product;
import com.satyanand.cataloginfrastructure.persistence.entity.ProductEntity;

public class ProductMapper {
    public static ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                null //  later we will do category mapping
        );
    }
}
