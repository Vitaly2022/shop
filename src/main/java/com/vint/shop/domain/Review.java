package com.vint.shop.domain;

import javax.persistence.*;

@Entity
@Table (name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "product_id") // connection
    private int product_id;

    @Column(name = "users_id") // connection
    private int users_id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="created_at")
    private String created_at;





}
