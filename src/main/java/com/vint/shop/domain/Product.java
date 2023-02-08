package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name="product")
public class Product {   // toString сделать

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "supplier_id")
    private Supplier supplier;

    @Column(name = "name")
    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "subcategory_id")
    private SubCategory subcategory;

    @Column(name = "discription")
    private String discription;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "price")
    private float price;

    @Column (name ="quantity")
    private int quantity;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderProduct> orderProducts;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    private List<Review> reviews;

    @Column (name ="rating")
    private int rating;

    @Column (name ="usersvote")
    private int usersvote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubCategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubCategory subcategory) {
        this.subcategory = subcategory;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
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

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUsersvote() {
        return usersvote;
    }

    public void setUsersvote(int usersvote) {
        this.usersvote = usersvote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId() && Float.compare(product.getPrice(), getPrice()) == 0 && getQuantity() == product.getQuantity() && getRating() == product.getRating() && getUsersvote() == product.getUsersvote() && Objects.equals(getSupplier(), product.getSupplier()) && Objects.equals(getName(), product.getName()) && Objects.equals(getSubcategory(), product.getSubcategory()) && Objects.equals(getDiscription(), product.getDiscription()) && Objects.equals(getManufacturer(), product.getManufacturer()) && Objects.equals(getOrderProducts(), product.getOrderProducts()) && Objects.equals(getReviews(), product.getReviews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSupplier(), getName(), getSubcategory(), getDiscription(), getManufacturer(), getPrice(), getQuantity(), getOrderProducts(), getReviews(), getRating(), getUsersvote());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", name='" + name + '\'' +
                ", subcategory=" + subcategory +
                ", discription='" + discription + '\'' +
                ", manufacturer=" + manufacturer +
                ", price=" + price +
                ", quantity=" + quantity +
                ", rating=" + rating +
                ", usersvote=" + usersvote +
                '}';
    }
}
