package com.example.xukashop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

//account product bill detail_bill permission supply promotion productCategory account_detail

@Getter
@Setter
@Entity
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

    @ElementCollection
    private List<Image> images = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<ProductOption> productOptions = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
}
