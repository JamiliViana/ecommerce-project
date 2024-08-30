package com.jamili.ecommerce.config.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String email){
        super(String.format("User com o email %s não foi encontrado", email));
    }

    public UserNotFoundException(int id){
        super(String.format("User com o id %d não foi encontrado", id));
    }
}
