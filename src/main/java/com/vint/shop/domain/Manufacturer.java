package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @OneToMany (fetch = FetchType.LAZY, mappedBy = "manufacturer")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), products);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
