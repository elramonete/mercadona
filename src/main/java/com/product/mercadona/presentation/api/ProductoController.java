package com.product.mercadona.presentation.api;

import com.product.mercadona.application.dto.ProductoCommand;
import com.product.mercadona.application.dto.ProductoResponse;
import com.product.mercadona.application.exception.producto.ProductoAlreadyExistsException;
import com.product.mercadona.application.exception.producto.ProductoNotFoundException;
import com.product.mercadona.application.usecase.crear.CrearProductoUseCase;
import com.product.mercadona.application.usecase.obtener.ObtenerProductoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Productos", description = "Gestión de productos")
@RestController
@RequestMapping("/mercadona/productos")
public class ProductoController {

    @Autowired
    private CrearProductoUseCase crearProductoUseCase;

    @Autowired
    private ObtenerProductoUseCase obtenerProductoUseCase;

    @Operation(summary = "Crear un nuevo producto", description = "Crea un nuevo producto en el sistema")
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody ProductoCommand productoCommand) {
        try {
            ProductoResponse nuevoProducto = crearProductoUseCase.crearProducto(productoCommand);
            return ResponseEntity.ok(nuevoProducto);
        } catch (ProductoAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The product already exists.");
        }
    }

    @Operation(summary = "Obtener todos los productos", description = "Obtiene una lista de todos los productos")
    @GetMapping
    public ResponseEntity<?> obtenerTodosLosProductos() {
        List<ProductoResponse> productos = obtenerProductoUseCase.obtenerTodosLosProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found.");
        }
        return ResponseEntity.ok(productos);
    }

    @Operation(summary = "Obtener un producto por ID", description = "Obtiene un producto específico por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable Long id) {
        try {
            ProductoResponse producto = obtenerProductoUseCase.obtenerProductoPorId(id);
            return ResponseEntity.ok(producto);
        } catch (ProductoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
    }
}
