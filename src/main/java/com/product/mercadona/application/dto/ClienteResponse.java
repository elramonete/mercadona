package com.product.mercadona.application.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class ClienteResponse {
    @Schema(description = "ID del cliente", example = "1")
    Long id;
    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    String nombre;
    @Schema(description = "Dirección del cliente", example = "Calle Falsa 123")
    String direccion;
    @Schema(description = "Teléfono del cliente", example = "123456789")
    String telefono;
    @Schema(description = "Email del cliente")
    String email; // Suponiendo que tienes un DTO para Email
}