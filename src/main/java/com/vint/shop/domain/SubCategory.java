package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;

    @Column (name = "name")
    private String name;

    @Column(name = "category_id")
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "id")
    private List<Category> category_id;

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

    public List<Category> getCategory_id() {
        return category_id;
    }

    public void setCategory_id(List<Category> category_id) {
        this.category_id = category_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getCategory_id(), that.getCategory_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory_id());
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
