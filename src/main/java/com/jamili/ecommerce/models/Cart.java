package com.jamili.ecommerce.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cart")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Transient
    private double totalCartValue;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
