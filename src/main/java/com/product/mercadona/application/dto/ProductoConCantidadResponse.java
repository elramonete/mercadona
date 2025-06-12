package com.product.mercadona.application.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductoConCantidadResponse {
    Long id;
    String nombre;
    double precio;
    int cantidad;
}
