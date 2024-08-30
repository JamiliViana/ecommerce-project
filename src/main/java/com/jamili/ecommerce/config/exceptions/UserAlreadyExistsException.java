package com.jamili.ecommerce.config.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String emailOrCpf){
        super(String.format("O email ou CPF já está cadastrado"));
    }
}
