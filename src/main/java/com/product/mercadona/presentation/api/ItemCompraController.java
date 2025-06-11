package com.product.mercadona.presentation.api;
import com.product.mercadona.application.dto.ItemCompraRequest;
import com.product.mercadona.application.dto.ItemCompraResponse;

import com.product.mercadona.application.exception.compra.ItemCompraNotFoundException;
import com.product.mercadona.application.usecase.compra.RealizarCompraUseCase;
import com.product.mercadona.application.usecase.obtener.ObtenerComprasPorClienteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Tag(name = "Items de Compra", description = "Gestión de items de compra")
@RestController
@RequestMapping("/mercadona/items")
public class ItemCompraController {
    @Autowired
    private RealizarCompraUseCase realizarCompraUseCase;
    @Autowired
    private ObtenerComprasPorClienteUseCase obtenerComprasPorClienteUseCase;
    @Operation(summary = "Realizar una compra", description = "Registra una compra de productos para un cliente")
    @PostMapping("/realizar")
    public ResponseEntity<?> realizarCompra(@RequestBody List<ItemCompraRequest> itemCompraRequests, @RequestParam Long clienteId) {
        try {
            List<ItemCompraResponse> itemsComprados = realizarCompraUseCase.ejecutar(clienteId, itemCompraRequests);
            return ResponseEntity.ok(itemsComprados);
        } catch (ItemCompraNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrada.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al realizar la compra.");
        }
    }
    @Operation(summary = "Obtener compras por cliente", description = "Obtiene todas las compras realizadas por un cliente específico")
    @GetMapping("/{clienteId}")
    public ResponseEntity<?> obtenerComprasPorCliente(@PathVariable Long clienteId) {
        try {
            List<ItemCompraResponse> compras = obtenerComprasPorClienteUseCase.ejecutar(clienteId);
            return ResponseEntity.ok(compras);
        } catch (ItemCompraNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron compras para este cliente.");
        }
    }
}