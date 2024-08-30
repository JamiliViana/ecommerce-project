package com.jamili.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String username;
    private String email;
    private String mobile;
    private String address;
    private String password;
    private String cpf;
    private String role;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Cart cart;

    public User(String username, String email, String mobile, String address, String password, String cpf) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
        this.cpf = cpf;
    }
}
