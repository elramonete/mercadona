package com.product.mercadona.application.mapper;

import com.product.mercadona.application.dto.ClienteCommand;
import com.product.mercadona.application.dto.ClienteResponse;
import com.product.mercadona.domain.Cliente;
import com.product.mercadona.domain.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "email", target = "email", qualifiedByName = "stringToEmail")
    Cliente toEntity(ClienteCommand clienteCommand);

    @Mapping(source = "email", target = "email", qualifiedByName = "emailToString")
    ClienteResponse toResponse(Cliente cliente);

    @Named("stringToEmail")
    default Email stringToEmail(String email) {
        return new Email(email);
    }
    @Named("emailToString")
    default String emailToString(Email email) {
        return email.getEmail();
    }
}

