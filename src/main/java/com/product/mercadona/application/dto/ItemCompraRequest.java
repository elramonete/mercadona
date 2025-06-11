package com.product.mercadona.application.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class ItemCompraRequest {
    @Schema(description = "ID del producto", example = "1")
    Long productoId; // ID del producto
    @Schema(description = "Cantidad a comprar", example = "2")
    int cantidad; // Cantidad a comprar
}