package com.satyanand.cataloginfrastructure.persistence.mapper;

import com.satyanand.catalogdomain.model.Category;
import com.satyanand.cataloginfrastructure.persistence.entity.CategoryEntity;

public class CategoryMapper {

    public static Category mapToDomain(CategoryEntity entity) {
        Category parent = null;

        if (entity.getParent() != null) {
            parent = new Category(
                    entity.getParent().getId(),
                    entity.getParent().getName(),
                    null
            );
        }

        return new Category(
                entity.getId(),
                entity.getName(),
                parent
        );
    }
}
