package com.jamili.ecommerce.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int costumerId;

    private String costumerName;
    private String email;
    private String mobile;
    private String address;
    private String password;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    public Customer(String costumerName, String email, String mobile, String address, String password) {
        this.costumerName = costumerName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
    }
}
