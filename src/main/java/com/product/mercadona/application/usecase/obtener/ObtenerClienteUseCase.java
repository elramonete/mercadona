package com.product.mercadona.application.usecase.obtener;

import com.product.mercadona.application.dto.ClienteResponse;
import com.product.mercadona.application.exception.cliente.ClienteNotFoundException;
import com.product.mercadona.application.mapper.ClienteMapper;
import com.product.mercadona.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObtenerClienteUseCase {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteResponse> obtenerTodosLosClientes() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponse obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toResponse)
                .orElseThrow(() -> new ClienteNotFoundException("Client not found with ID: " + id));
    }
}
