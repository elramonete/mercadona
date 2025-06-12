package com.product.mercadona.application.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import java.util.List;
@Value
@Builder
public class CestaDeCompraResponse {
    @Schema(description = "ID de la cesta", example = "1")
    Long id;
    @Schema(description = "ID del cliente asociado a la cesta", example = "1")
    Long clienteId;
    @Schema(description = "Lista de productos en la cesta")
    List<ProductoConCantidadResponse> productos; // Lista de productos en la cesta
    @Schema(description = "Total de la cesta", example = "10.50")
    double total; // Total de la cesta
}