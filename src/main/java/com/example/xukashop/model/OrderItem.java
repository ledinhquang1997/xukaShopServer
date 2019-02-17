package com.example.xukashop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Option option;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Order order;

    private String note;

    private int quantity;

    private double sale;

    private double subtotal;
}
