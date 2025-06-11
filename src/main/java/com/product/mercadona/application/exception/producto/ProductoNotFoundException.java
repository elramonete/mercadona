package com.product.mercadona.application.exception.producto;

public class ProductoNotFoundException extends RuntimeException{
    public ProductoNotFoundException(String message){
        super(message);
    }
}
