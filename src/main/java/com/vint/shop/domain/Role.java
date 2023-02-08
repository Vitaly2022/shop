package com.vint.shop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "role_id")
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "id")
    private List<User> user_id;

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
        Role role = (Role) o;
        return getId() == role.getId() && Objects.equals(name, role.name) && Objects.equals(user_id, role.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, user_id);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +           '}';
    }
}
