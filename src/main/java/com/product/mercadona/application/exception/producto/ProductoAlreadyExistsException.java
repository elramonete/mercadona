package com.product.mercadona.application.exception.producto;

public class ProductoAlreadyExistsException extends RuntimeException{
    public ProductoAlreadyExistsException(String message){
        super(message);
    }
}
