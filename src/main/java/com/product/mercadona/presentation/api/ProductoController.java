package com.product.mercadona.presentation.api;


import com.product.mercadona.application.dto.ProductoCommand;
import com.product.mercadona.application.dto.ProductoResponse;
import com.product.mercadona.application.usecase.CrearProductoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Productos", description = "Gestión de productos")
@RestController
@RequestMapping("/mercadona/productos")
public class ProductoController {

    @Autowired
    private CrearProductoUseCase crearProductoUseCase;

    @Operation(summary = "Crear un nuevo producto", description = "Crea un nuevo producto en el sistema")
    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(@RequestBody ProductoCommand productoCommand) {
        ProductoResponse nuevoProducto = crearProductoUseCase.crearProducto(productoCommand);
        return ResponseEntity.ok(nuevoProducto);
    }

    @Operation(summary = "Obtener todos los productos", description = "Obtiene una lista de todos los productos")
    @GetMapping
    public ResponseEntity<List<ProductoResponse>> obtenerTodosLosProductos() {
        List<ProductoResponse> productos = crearProductoUseCase.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }
}

