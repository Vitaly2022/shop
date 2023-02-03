package com.vint.shop.domain;

import javax.persistence.*;

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
    @OneToMany//дописать
    private int role_id;

    @Column(name = "registered_at")
    private String registered_at;



}
