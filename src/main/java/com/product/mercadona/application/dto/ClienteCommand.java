package com.product.mercadona.application.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class ClienteCommand {
    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    String nombre;
    @Schema(description = "Dirección del cliente", example = "Calle Falsa 123")
    String direccion;
    @Schema(description = "Teléfono del cliente", example = "123456789")
    String telefono;
    @Schema(description = "Email del cliente", example = "juan.perez@example.com")
    String email; // El email como String para la creación
}
