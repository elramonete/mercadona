package com.product.mercadona.application.exception.cesta;
public class CestaDeCompraNotFoundException extends RuntimeException {
    public CestaDeCompraNotFoundException(String message) {
        super(message);
    }
    public CestaDeCompraNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}