package com.example.xukashop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//account product bill detail_bill permission supply promotion productCategory account_detail
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private String description;
    private boolean isActive = true;
    private Date dateCreated = new Date();
    private Date lastUpdated = new Date();
    private float rating;
    private int numberOfReviewer;
    private double price;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<Option> options = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
}
