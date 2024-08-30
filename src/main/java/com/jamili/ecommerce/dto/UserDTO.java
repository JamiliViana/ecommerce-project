package com.jamili.ecommerce.dto;

import com.jamili.ecommerce.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
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

    public UserDTO(String name, String email, String mobile, String address, String password, String cpf) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
        this.cpf = cpf;
    }
    public User transformToUser(UserDTO userDTO){
        return new User(
                userDTO.name,
                userDTO.email,
                userDTO.mobile,
                userDTO.address,
                userDTO.password,
                userDTO.cpf);
    }

}
