package com.satyanand.catalogdomain.model;

import java.util.List;

public class Category {

    private Long id;
    private String name;
    private Category parent;
    private List<Category> children;

    public Category(Long id, String name, Category parent){
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getParent() {
        return parent;
    }

    public List<Category> getChildren() {
        return children;
    }
}
