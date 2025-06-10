package com.product.mercadona.presentation.api;


import com.product.mercadona.application.dto.ClienteCommand;
import com.product.mercadona.application.dto.ClienteResponse;
import com.product.mercadona.application.usecase.CrearClienteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Gestión de clientes")
@RestController
@RequestMapping("/mercadona/clientes")
public class ClienteController {

    @Autowired
    private CrearClienteUseCase crearClienteUseCase;
/*
    @Operation(summary = "Crear un nuevo cliente", description = "Crea un nuevo cliente en el sistema")
    @PostMapping
    public<ClienteResponse> crearCliente(@RequestBody ClienteCommand clienteCommand) {
        ClienteResponse nuevoCliente = crearClienteUseCase.crearCliente(clienteCommand);
        return ResponseEntity.ok(nuevoCliente);
    }*/

    @Operation(summary = "Obtener todos los clientes", description = "Obtiene una lista de todos los clientes")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obtenerTodosLosClientes() {
        List<ClienteResponse> clientes = crearClienteUseCase.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }
}

