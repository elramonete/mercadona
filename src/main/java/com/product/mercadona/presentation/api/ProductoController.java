package com.product.mercadona.presentation.api;


import com.product.mercadona.application.dto.ProductoCommand;
import com.product.mercadona.application.dto.ProductoResponse;
import com.product.mercadona.application.usecase.CrearProductoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercadona/productos")
public class ProductoController {
    @Autowired
    private CrearProductoUseCase crearProductoUseCase;
    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(@RequestBody ProductoCommand productoCommand) {
        ProductoResponse nuevoProducto = crearProductoUseCase.crearProducto(productoCommand);
        return ResponseEntity.ok(nuevoProducto);
    }
    // Puedes agregar más métodos aquí para manejar otras operaciones, como obtener productos, etc.
    @GetMapping
    public ResponseEntity<List<ProductoResponse>> obtenerTodosLosProductos() {
        List<ProductoResponse> productos = crearProductoUseCase.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }
}
