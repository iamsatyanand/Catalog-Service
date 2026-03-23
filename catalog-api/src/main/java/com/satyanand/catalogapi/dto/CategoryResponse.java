package com.satyanand.catalogapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
@JsonPropertyOrder({ "id", "name", "parentId", "children" })
public class CategoryResponse {

    private Long id;
    private String name;
    private Long parentId;
    private List<CategoryResponse> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<CategoryResponse> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryResponse> children) {
        this.children = children;
    }
}
