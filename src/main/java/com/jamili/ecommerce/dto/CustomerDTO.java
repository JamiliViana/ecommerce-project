package com.jamili.ecommerce.dto;

import com.jamili.ecommerce.models.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Escreva email no formato correto")
    private String email;
    @NotBlank(message = "O número de celular é obrigatório")
    private String mobile;
    @NotBlank(message = "Endereço é obrigatório")
    private String address;
    @NotBlank(message = "Senha é obrigatório")
    private String password;
    @NotBlank(message = "Cpf é obrigatório")
    private String cpf;

    public CustomerDTO(String name, String email, String mobile, String address, String password, String cpf) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
        this.cpf = cpf;
    }
    public Customer transformToCustomer(CustomerDTO customerDTO){
        return new Customer(
                customerDTO.name,
                customerDTO.email,
                customerDTO.mobile,
                customerDTO.address,
                customerDTO.password,
                customerDTO.cpf);
    }

}
