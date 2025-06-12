package com.product.mercadona.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class ProductoCantidadDTO {
    @Schema(description = "ID del producto", example = "1")
    Long productoId;

    @Schema(description = "Cantidad del producto", example = "2")
    int cantidad;
}
