package com.vint.shop.domain;

import javax.persistence.*;

@Entity
@Table (name="orderproduct")
public class OrderProduct { //Getters and Setters + .........

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "product_id") //connection
    private int product_id;

    @Column(name = "order_id") //connection
    private int order_id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

}
