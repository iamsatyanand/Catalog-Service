package com.satyanand.catalogapi.config;

import com.satyanand.catalogapplication.service.CategoryService;
import com.satyanand.catalogdomain.repository.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class ApplicationConfig {

    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }
}