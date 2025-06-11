package com.product.mercadona.application.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class ProductoCommand {
    @Schema(description = "Nombre del producto", example = "Manzana")
    String nombre;
    @Schema(description = "Categoría del producto", example = "Frutas")
    String categoria;
    @Schema(description = "Precio del producto", example = "1.99")
    Double precio;
}