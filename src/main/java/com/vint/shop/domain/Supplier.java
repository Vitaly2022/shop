package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Supplier { // toString

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String email;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "supplier")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        Supplier supplier = (Supplier) o;
        return getId() == supplier.getId() && Objects.equals(getName(), supplier.getName()) && Objects.equals(getEmail(), supplier.getEmail()) && Objects.equals(getProducts(), supplier.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getProducts());
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
