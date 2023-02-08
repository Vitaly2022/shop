package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name="subcategory")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;

    @Column (name = "name")
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "category_id")
    private Category category;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "subcategory")
    private List<Product> products;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getProducts());
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
