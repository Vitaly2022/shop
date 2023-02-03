package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "users")
public class Users {
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

    @Column(name = "role_id")
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "id")
    private List<Roles> role_id;

    @Column(name = "registered_at")
    private String registered_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(password_hash, users.password_hash) && Objects.equals(first_name, users.first_name) && Objects.equals(last_name, users.last_name) && Objects.equals(email, users.email) && Objects.equals(mobile, users.mobile) && Objects.equals(role_id, users.role_id) && Objects.equals(registered_at, users.registered_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password_hash, first_name, last_name, email, mobile, role_id, registered_at);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", password_hash='" + password_hash + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", registered_at='" + registered_at + '\'' +
                '}';
    }
}
