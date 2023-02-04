package com.vint.shop.domain;

import javax.persistence.*;

@Entity
@Table (name = "order")
public class Order { //connection + toString and get set add hash /

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "users_id") //connection
    private int users_id;

    @Column(name = "status")
    private String status;

    @Column(name = "grand_total")
    private float grand_total;

    @Column(name = "date_order")
    private String date_order;

    @Column(name = "description")
    private String description;




}
