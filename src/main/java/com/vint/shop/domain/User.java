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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", registered_at='" + registered_at + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(password_hash, user.password_hash) && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(email, user.email) && Objects.equals(mobile, user.mobile) && Objects.equals(role, user.role) && Objects.equals(registered_at, user.registered_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), password_hash, first_name, last_name, email, mobile, role, registered_at);
    }
}
