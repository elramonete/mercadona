package com.product.mercadona.presentation.api;
import com.product.mercadona.application.dto.CestaDeCompraCommand;
import com.product.mercadona.application.dto.CestaDeCompraResponse;
import com.product.mercadona.application.exception.cesta.CestaDeCompraNotFoundException;
import com.product.mercadona.application.usecase.borrar.EliminarProductoDeCestaUseCase;
import com.product.mercadona.application.usecase.crear.AgregarProductoACestaUseCase;

import com.product.mercadona.application.usecase.obtener.ObtenerCestaDeCompraUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Tag(name = "Cestas de Compra", description = "Gestión de cestas de compra")
@RestController
@RequestMapping("/mercadona/cestas")
public class CestaDeCompraController {
    @Autowired
    private AgregarProductoACestaUseCase agregarProductoACestaUseCase;
    @Autowired
    private EliminarProductoDeCestaUseCase eliminarProductoDeCestaUseCase;
    @Autowired
    private ObtenerCestaDeCompraUseCase obtenerCestaDeCompraUseCase;
    @Operation(summary = "Agregar un producto a la cesta", description = "Agrega un producto a la cesta de compra del cliente")
    @PostMapping("/agregar")
    public ResponseEntity<?> agregarProducto(@RequestBody CestaDeCompraCommand cestaDeCompraCommand) {
        try {
            agregarProductoACestaUseCase.ejecutar(cestaDeCompraCommand);
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto agregado a la cesta.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al agregar el producto a la cesta.");
        }
    }
    @Operation(summary = "Eliminar un producto de la cesta", description = "Elimina un producto de la cesta de compra del cliente")
    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarProducto(@RequestBody CestaDeCompraCommand cestaDeCompraCommand) {
        try {
            eliminarProductoDeCestaUseCase.ejecutar(cestaDeCompraCommand);
            return ResponseEntity.ok("Producto eliminado de la cesta.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al eliminar el producto de la cesta.");
        }
    }
    @Operation(summary = "Obtener la cesta de compra", description = "Obtiene la cesta de compra del cliente")
    @GetMapping("/{clienteId}")
    public ResponseEntity<?> obtenerCestaDeCompra(@PathVariable Long clienteId) {
        try {
            CestaDeCompraResponse cesta = obtenerCestaDeCompraUseCase.ejecutar(clienteId);
            return ResponseEntity.ok(cesta);
        } catch (CestaDeCompraNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cesta de compra no encontrada.");
        }
    }
}