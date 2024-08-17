package com.jamili.ecommerce.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_cart")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items;

    @Transient
    private double totalCartValue;

    @OneToOne
    @JoinColumn(name = "custumer_customerid", nullable = false)
    private Customer customer;

}
