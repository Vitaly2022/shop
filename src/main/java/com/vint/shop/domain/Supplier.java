package com.vint.shop.domain;

import javax.persistence.*;
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

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "product_id")
    private Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return getId() == supplier.getId() && Objects.equals(getName(), supplier.getName()) && Objects.equals(getEmail(), supplier.getEmail()) && Objects.equals(getProduct(), supplier.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getProduct());
    }


}
