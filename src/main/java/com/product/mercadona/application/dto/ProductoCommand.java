package com.product.mercadona.application.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCommand {
    private String nombre;
    private String categoria;
    private Double precio;
}