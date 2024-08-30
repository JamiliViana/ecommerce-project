package com.jamili.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_product")
@Getter
@Setter
public class Product {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String productName;
    private int stock;
    private String description;
    private double productPrice;

}
