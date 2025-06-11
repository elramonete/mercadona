package com.product.mercadona.application.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCommand {
    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    private String nombre;

    @Schema(description = "Dirección del cliente", example = "Calle Falsa 123")
    private String direccion;

    @Schema(description = "Teléfono del cliente", example = "+34 123 456 789")
    private String telefono;

    @Schema(description = "Email del cliente", example = "juan.perez@example.com")
    private String email;
}
