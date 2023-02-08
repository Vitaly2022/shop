package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "\"user\"")
public class User { //изменить название класса
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "password_hash")
    private String password_hash;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "role_id")
    private Role role;

    @Column(name = "registered_at")
    private String registered_at;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orders;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    private List<Review> reviews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRegistered_at() {
        return registered_at;
    }

    public void setRegistered_at(String registered_at) {
        this.registered_at = registered_at;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getPassword_hash(), user.getPassword_hash()) && Objects.equals(getFirst_name(), user.getFirst_name()) && Objects.equals(getLast_name(), user.getLast_name()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getMobile(), user.getMobile()) && Objects.equals(getRole(), user.getRole()) && Objects.equals(getRegistered_at(), user.getRegistered_at()) && Objects.equals(getOrders(), user.getOrders()) && Objects.equals(getReviews(), user.getReviews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassword_hash(), getFirst_name(), getLast_name(), getEmail(), getMobile(), getRole(), getRegistered_at(), getOrders(), getReviews());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password_hash='" + password_hash + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", registered_at='" + registered_at + '\'' +
                '}';
    }
}
