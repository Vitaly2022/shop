package com.vint.shop.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<OrderProductMap> orderproductmaps;

    @Column(name = "status")
    private String status;

    @Column(name = "grand_total")
    private float grand_total;

    @Column(name = "date_order")
    private LocalDate date_order;

    @Column(name = "description")
    private String description;

    public long getId() {
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

    public List<OrderProductMap> getOrderproductmaps() {
        return orderproductmaps;
    }

    public void setOrderproductmaps(List<OrderProductMap> orderproductmaps) {
        this.orderproductmaps = orderproductmaps;
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

    public LocalDate getDate_order() {
        return date_order;
    }

    public void setDate_order(LocalDate date_order) {
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
        Order order = (Order) o;
        return id == order.id && Float.compare(order.grand_total, grand_total) == 0 && Objects.equals(user, order.user) && Objects.equals(orderproductmaps, order.orderproductmaps) && Objects.equals(status, order.status) && Objects.equals(date_order, order.date_order) && Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, orderproductmaps, status, grand_total, date_order, description);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", status='" + status + '\'' +
                ", grand_total=" + grand_total +
                ", date_order=" + date_order +
                ", description='" + description + '\'' +
                '}';
    }
}
