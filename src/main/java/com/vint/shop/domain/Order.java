package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User user;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "order")
    private List<Order> order;

    @Column(name = "status")
    private String status;

    @Column(name = "grand_total")
    private float grand_total;

    @Column(name = "date_order")
    private String date_order;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(float grand_total) {
        this.grand_total = grand_total;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order1 = (Order) o;
        return getId() == order1.getId() && Float.compare(order1.getGrand_total(), getGrand_total()) == 0 && Objects.equals(getUser(), order1.getUser()) && Objects.equals(getOrder(), order1.getOrder()) && Objects.equals(getStatus(), order1.getStatus()) && Objects.equals(getDate_order(), order1.getDate_order()) && Objects.equals(getDescription(), order1.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getOrder(), getStatus(), getGrand_total(), getDate_order(), getDescription());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", status='" + status + '\'' +
                ", grand_total=" + grand_total +
                ", date_order='" + date_order + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
