package com.product.mercadona.application.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCommand {

    @Schema(description = "Nombre del producto", example = "Manzana")
    private String nombre;

    @Schema(description = "Categoría del producto", example = "Frutas")
    private String categoria;

    @Schema(description = "Precio del producto", example = "1.99")
    private Double precio;
}
