package com.product.mercadona.application.mapper;
import com.product.mercadona.application.dto.ItemCompraRequest;
import com.product.mercadona.application.dto.ItemCompraResponse;
import com.product.mercadona.domain.ItemCompra;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface ItemCompraMapper {
    ItemCompraMapper INSTANCE = Mappers.getMapper(ItemCompraMapper.class);
    ItemCompraResponse toResponse(ItemCompra itemCompra);
    ItemCompra toEntity(ItemCompraRequest itemCompraRequest);
}