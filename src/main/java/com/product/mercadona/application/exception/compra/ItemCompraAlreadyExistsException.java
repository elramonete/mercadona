package com.product.mercadona.application.exception.compra;
public class ItemCompraAlreadyExistsException extends RuntimeException {
    public ItemCompraAlreadyExistsException(String message) {
        super(message);
    }
    public ItemCompraAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}