package com.product.mercadona.application.mapper;
import com.product.mercadona.application.dto.CestaDeCompraCommand;
import com.product.mercadona.application.dto.CestaDeCompraResponse;
import com.product.mercadona.domain.CestaDeCompra;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface CestaDeCompraMapper {
    CestaDeCompraMapper INSTANCE = Mappers.getMapper(CestaDeCompraMapper.class);
    CestaDeCompraResponse toResponse(CestaDeCompra cestaDeCompra);
    CestaDeCompra toEntity(CestaDeCompraCommand cestaDeCompraCommand);
}
