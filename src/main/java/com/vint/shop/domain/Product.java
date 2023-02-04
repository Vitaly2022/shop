package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {   // toString сделать

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "supplier_id") //connection
    OneToMany (fetch = FetchType.LAZY, mappedBy = "id")
    private List<Supplier> supplier_id;


    @Column(name = "name")
    private String name;

    @Column(name = "subcategory_id") //connection
    private int subcategory_id;

    @Column(name = "discription")
    private String discription;

    @Column(name = "manufacturer_id") //connection
    private int manufacturer_id;

    @Column(name = "price")
    private float price;

    @Column (name ="quantity")
    private int quantity;

    @Column (name ="rating")
    private int rating;

    @Column (name ="users_vote")
    private int users_vote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(int subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUsers_vote() {
        return users_vote;
    }

    public void setUsers_vote(int users_vote) {
        this.users_vote = users_vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId() && getSupplier_id() == product.getSupplier_id() && getSubcategory_id() == product.getSubcategory_id() && getManufacturer_id() == product.getManufacturer_id() && Float.compare(product.getPrice(), getPrice()) == 0 && getQuantity() == product.getQuantity() && getRating() == product.getRating() && getUsers_vote() == product.getUsers_vote() && Objects.equals(getName(), product.getName()) && Objects.equals(getDiscription(), product.getDiscription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSupplier_id(), getName(), getSubcategory_id(), getDiscription(), getManufacturer_id(), getPrice(), getQuantity(), getRating(), getUsers_vote());
    }
}
