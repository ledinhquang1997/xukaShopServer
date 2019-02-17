package com.example.xukashop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Embeddable
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<OrderItem> orderItems = new HashSet<>();

    private String address;
    private String note;
    private boolean isShipped;
    private Date dateCreated;
    private Date lastUpdated;
    private boolean done;
}
