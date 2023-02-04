package com.vint.shop.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {   // toString сделать

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "supplier_id") //connection
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "id")
    private List<Supplier> supplier_id;


    @Column(name = "name")
    private String name;

    @Column(name = "subcategory_id") //connection
    private int subcategory_id;

    @Column(name = "discription")
    private String discription;

    @Column(name = "manufacturer_id") //connection
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "id")
    private List <Manufacturer> manufacturer;

    @Column(name = "price")
    private float price;

    @Column (name ="quantity")
    private int quantity;

    @Column (name ="rating")
    private int rating;

    @Column (name ="users_vote")
    private int users_vote;

}
