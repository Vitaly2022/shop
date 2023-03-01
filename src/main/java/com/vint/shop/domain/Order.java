package com.vint.shop.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "myorder")
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
    private BigDecimal grand_total;

    @Column(name = "dateoforder")
    private LocalDate dateoforder;

    @Column(name = "description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public BigDecimal getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(BigDecimal grand_total) {
        this.grand_total = grand_total;
    }

    public LocalDate getDateoforder() {
        return dateoforder;
    }

    public void setDateoforder(LocalDate dateoforder) {
        this.dateoforder = dateoforder;
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
        return id == order.id && Objects.equals(user, order.user) && Objects.equals(orderproductmaps, order.orderproductmaps) && Objects.equals(status, order.status) && Objects.equals(grand_total, order.grand_total) && Objects.equals(dateoforder, order.dateoforder) && Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, orderproductmaps, status, grand_total, dateoforder, description);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", status=" + status +
                ", grand_total=" + grand_total +
                ", description='" + description + '\'' +
                '}';
    }
}
