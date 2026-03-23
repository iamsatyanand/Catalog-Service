package com.satyanand.cataloginfrastructure.persistence.adapter;

import com.satyanand.catalogdomain.model.Category;
import com.satyanand.catalogdomain.repository.CategoryRepository;
import com.satyanand.cataloginfrastructure.persistence.entity.CategoryEntity;
import com.satyanand.cataloginfrastructure.persistence.mapper.CategoryMapper;
import com.satyanand.cataloginfrastructure.persistence.repository.JpaCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JpaCategoryRepository jpaRepository;

    @Override
    public Category save(Category category) {

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .name(category.getName())
                .parent(null)
                .build();

        if(category.getParent() != null){
            CategoryEntity entity = jpaRepository.findById(category.getParent().getId())
                    .orElseThrow(() -> new RuntimeException("Parent not found"));
            categoryEntity.setParent(entity);
        }


        return CategoryMapper.mapToDomain(jpaRepository.save(categoryEntity));
    }

    @Override
    public Optional<Category> findById(Long id) {
        return jpaRepository.findById(id)
                .map(CategoryMapper::mapToDomain);
    }

    @Override
    public List<Category> findAll() {
        return jpaRepository.findAll().stream()
                .map(CategoryMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
