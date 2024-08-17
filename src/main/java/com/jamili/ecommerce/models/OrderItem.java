package com.jamili.ecommerce.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_orderitem")
@Getter
@Setter
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    private int quantityItem;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "cart_cartid", nullable = false)
    private Cart cart;

}
