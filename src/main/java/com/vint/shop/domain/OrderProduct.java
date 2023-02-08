package com.vint.shop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name="orderproduct")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "product_id")
    private Product product;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return getId() == that.getId() && getQuantity() == that.getQuantity() && Float.compare(that.getPrice(), getPrice()) == 0 && Objects.equals(getProduct(), that.getProduct()) && Objects.equals(getOrder(), that.getOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduct(), getOrder(), getQuantity(), getPrice());
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
