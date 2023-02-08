package com.vint.shop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "subcategory_id")
    private SubCategory subCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return getId() == category.getId() && Objects.equals(getName(), category.getName()) && Objects.equals(getSubCategory(), category.getSubCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSubCategory());
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subCategory=" + subCategory +
                '}';
    }
}
