package com.product.mercadona.application.usecase.crear;

import com.product.mercadona.application.dto.ClienteCommand;
import com.product.mercadona.application.dto.ClienteResponse;
import com.product.mercadona.application.mapper.ClienteMapper;
import com.product.mercadona.domain.Cliente;
import com.product.mercadona.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CrearClienteUseCase {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;
    public ClienteResponse crearCliente(ClienteCommand clienteCommand) {
        Cliente cliente = clienteMapper.toEntity(clienteCommand);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toResponse(cliente);
    }

}

