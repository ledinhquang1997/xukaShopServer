package com.example.xukashop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;


@Getter
@Setter
@Entity
public class ProductOption {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<OrderItem> orderItems = new HashSet<>();

    @ElementCollection
    private List<Image> images = new ArrayList<>();

    private int stock;
    private boolean isActive;
    private String description;
    private Date dateCreated;
    private Date dateUpdated;
}
