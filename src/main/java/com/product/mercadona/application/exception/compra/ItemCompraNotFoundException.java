package com.product.mercadona.application.exception.compra;
public class ItemCompraNotFoundException extends RuntimeException {
    public ItemCompraNotFoundException(String message) {
        super(message);
    }
    public ItemCompraNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
