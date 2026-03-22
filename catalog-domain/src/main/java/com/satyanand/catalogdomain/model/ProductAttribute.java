package com.satyanand.catalogdomain.model;

public class ProductAttribute {

    private Long id;
    private String name;
    private String value;

    public ProductAttribute(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
