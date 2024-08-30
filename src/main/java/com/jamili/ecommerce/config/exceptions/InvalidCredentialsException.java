package com.jamili.ecommerce.config.exceptions;

public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException(){
        super(String.format("Senha incorreta"));
    }
}
