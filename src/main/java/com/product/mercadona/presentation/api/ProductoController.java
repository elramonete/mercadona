package com.product.mercadona.presentation.api;


import com.product.mercadona.application.dto.ProductoCommand;
import com.product.mercadona.application.dto.ProductoResponse;
import com.product.mercadona.application.usecase.CrearProductoUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Api(tags = "Productos")
@RestController
@RequestMapping("/mercadona/productos")
public class ProductoController {
    @Autowired
    private CrearProductoUseCase crearProductoUseCase;
    @ApiOperation(value = "Crear un nuevo producto", response = ProductoResponse.class)
    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(@RequestBody ProductoCommand productoCommand) {
        ProductoResponse nuevoProducto = crearProductoUseCase.crearProducto(productoCommand);
        return ResponseEntity.ok(nuevoProducto);
    }
    @ApiOperation(value = "Obtener todos los productos", response = List.class)
    @GetMapping
    public ResponseEntity<List<ProductoResponse>> obtenerTodosLosProductos() {
        List<ProductoResponse> productos = crearProductoUseCase.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }
}
