package com.product.mercadona.application.exception.cliente;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String message){
        super(message);
    }
}
