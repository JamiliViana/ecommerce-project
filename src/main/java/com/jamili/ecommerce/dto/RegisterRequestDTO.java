package com.jamili.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO (
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 50, message = "Nome precisa ter de 2 a 50 letras")
        String name,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email precisa ser válido")
        String email,

        @NotBlank(message = "O número de celular é obrigatório")
        @Size(min = 10, max = 10, message = "Número de celular deve ter 10 dígitos contando o DDD")
        String mobile,

        @NotBlank(message = "Endereço é obrigatório")
        String address,

        @NotBlank(message = "Senha é obrigatória")
        String password,

        @NotBlank(message = "Cpf é obrigatório")
        @Size(min = 11, max = 11, message = "Cpf deve ter exatamente 11 dígitos")
        String cpf) {}
