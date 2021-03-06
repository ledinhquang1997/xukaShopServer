package com.example.xukashop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProductOption productOption;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Order order;

    private String note;

    private int quantity;

    private double sale;

    private double subtotal;
}
