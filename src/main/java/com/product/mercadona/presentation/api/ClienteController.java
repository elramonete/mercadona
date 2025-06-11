package com.product.mercadona.presentation.api;

import com.product.mercadona.application.dto.ClienteCommand;
import com.product.mercadona.application.dto.ClienteResponse;
import com.product.mercadona.application.exception.cliente.ClienteAlreadyExistsException;
import com.product.mercadona.application.exception.cliente.ClienteNotFoundException;
import com.product.mercadona.application.usecase.crear.CrearClienteUseCase;
import com.product.mercadona.application.usecase.obtener.ObtenerClienteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Gestión de clientes")
@RestController
@RequestMapping("/mercadona/clientes")
public class ClienteController {

    @Autowired
    private CrearClienteUseCase crearClienteUseCase;

    @Autowired
    private ObtenerClienteUseCase obtenerClienteUseCase;

    @Operation(summary = "Crear un nuevo cliente", description = "Crea un nuevo cliente en el sistema")
    @PostMapping
    public ResponseEntity<?> crearCliente(@RequestBody ClienteCommand clienteCommand) {
        try {
            ClienteResponse nuevoCliente = crearClienteUseCase.crearCliente(clienteCommand);
            return ResponseEntity.ok(nuevoCliente);
        } catch (ClienteAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The client already exists.");
        }
    }

    @Operation(summary = "Obtener todos los clientes", description = "Obtiene una lista de todos los clientes")
    @GetMapping
    public ResponseEntity<?> obtenerTodosLosClientes() {
        List<ClienteResponse> clientes = obtenerClienteUseCase.obtenerTodosLosClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No clients found.");
        }
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Obtener un cliente por ID", description = "Obtiene un cliente específico por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerClientePorId(@PathVariable Long id) {
        try {
            ClienteResponse cliente = obtenerClienteUseCase.obtenerClientePorId(id);
            return ResponseEntity.ok(cliente);
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
    }
}
