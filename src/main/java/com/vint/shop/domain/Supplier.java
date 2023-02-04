package com.vint.shop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Supplier { // toString

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String email;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "product_id")
    private Product product;

}
