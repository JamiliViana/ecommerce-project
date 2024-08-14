package com.jamili.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
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

    public Customer(String costumerName, String email, String mobile, String address) {
        this.costumerName = costumerName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }
}
