package com.product.mercadona.application.exception.cliente;

public class ClienteAlreadyExistsException extends RuntimeException{
    public ClienteAlreadyExistsException(String message){
        super(message);
    }
}
