package com.satyanand.catalogdomain.model;

import java.math.BigDecimal;
import java.util.List;

public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private List<ProductAttribute> attributes;

    public Product(Long id, String name, String description, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public List<ProductAttribute> getAttributes() {
        return attributes;
    }
}
