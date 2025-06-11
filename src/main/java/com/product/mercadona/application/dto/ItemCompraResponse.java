package com.product.mercadona.application.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class ItemCompraResponse {
    @Schema(description = "ID del item de compra", example = "1")
    Long id;
    @Schema(description = "ID del cliente", example = "1")
    Long clienteId;
    @Schema(description = "ID del producto", example = "1")
    Long productoId;
    @Schema(description = "Cantidad comprada", example = "2")
    int cantidad; // Cantidad comprada
}
