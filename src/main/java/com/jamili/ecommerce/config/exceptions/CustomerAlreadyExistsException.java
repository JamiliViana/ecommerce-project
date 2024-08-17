package com.jamili.ecommerce.config.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException{

    public CustomerAlreadyExistsException(String emailOrCpf){
        super(String.format("O email ou CPF já está cadastrado"));
    }
}
