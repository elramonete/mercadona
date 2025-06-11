package com.product.mercadona.application.exception.cesta;
public class CestaDeCompraAlreadyExistsException extends RuntimeException {
    public CestaDeCompraAlreadyExistsException(String message) {
        super(message);
    }
    public CestaDeCompraAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
