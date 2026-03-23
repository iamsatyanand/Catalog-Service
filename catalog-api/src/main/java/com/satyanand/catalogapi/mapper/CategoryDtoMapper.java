package com.satyanand.catalogapi.mapper;

import com.satyanand.catalogapi.dto.CategoryResponse;
import com.satyanand.catalogdomain.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDtoMapper {

    public static CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());

        if (category.getParent() != null) {
            response.setParentId(category.getParent().getId());
        }

        if (category.getChildren() != null) {
            List<CategoryResponse> children = category.getChildren()
                    .stream()
                    .map(CategoryDtoMapper::toResponse)
                    .collect(Collectors.toList());

            response.setChildren(children);
        }

        return response;
    }
}