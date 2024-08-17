package com.jamili.ecommerce.config.exceptions;

public class CustumerNotFoundException extends RuntimeException{

    public CustumerNotFoundException(String email){
        super(String.format("Cliente com o email %s não foi encontrado", email));
    }

    public CustumerNotFoundException(int id){
        super(String.format("Cliente com o id %d não foi encontrado", id));
    }
}
