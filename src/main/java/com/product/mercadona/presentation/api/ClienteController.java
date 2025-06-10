package com.product.mercadona.presentation.api;


import com.product.mercadona.application.dto.ClienteCommand;
import com.product.mercadona.application.dto.ClienteResponse;
import com.product.mercadona.application.usecase.CrearClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercadona/clientes")
public class ClienteController {
    @Autowired
    private CrearClienteUseCase crearClienteUseCase;
    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@RequestBody ClienteCommand clienteCommand) {
        ClienteResponse nuevoCliente = crearClienteUseCase.crearCliente(clienteCommand);
        return ResponseEntity.ok(nuevoCliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obtenerTodosLosClientes() {
        List<ClienteResponse> clientes = crearClienteUseCase.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }
}
