package com.product.mercadona.application.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import java.util.List;
@Value
@Builder
public class CestaDeCompraCommand {
    @Schema(description = "ID del cliente", example = "1")
    Long clienteId;
    @Schema(description = "Lista de IDs de productos a agregar", example = "[1, 2, 3]")
    List<Long> productoIds; // Lista de IDs de productos a agregar
}