package com.product.mercadona.application.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class ProductoResponse {
    @Schema(description = "ID del producto", example = "1")
    Long id;
    @Schema(description = "Nombre del producto", example = "Leche")
    String nombre;
    @Schema(description = "Categoría del producto", example = "Lácteos")
    String categoria;
    @Schema(description = "Precio del producto", example = "1.99")
    Double precio;
}