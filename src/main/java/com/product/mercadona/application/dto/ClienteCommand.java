package com.product.mercadona.application.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCommand {
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
}
