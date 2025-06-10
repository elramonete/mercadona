package com.product.mercadona.application.mapper;

import com.product.mercadona.application.dto.ClienteCommand;
import com.product.mercadona.application.dto.ClienteResponse;
import com.product.mercadona.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ClienteMapper {
    com.product.mercadona.application.mapper.ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    Cliente toEntity(ClienteCommand clienteCommand);
    ClienteResponse toResponse(Cliente cliente);
}
