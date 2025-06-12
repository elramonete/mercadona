package com.product.mercadona.application.mapper;

import com.product.mercadona.application.dto.ProductoCommand;
import com.product.mercadona.application.dto.ProductoConCantidadResponse;
import com.product.mercadona.application.dto.ProductoResponse;
import com.product.mercadona.domain.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
    Producto toEntity(ProductoCommand productoCommand);
    ProductoResponse toResponse(Producto producto);

    @Mapping(target = "id", source = "producto.id")
    @Mapping(target = "nombre", source = "producto.nombre")
    @Mapping(target = "precio", source = "producto.precio")
    @Mapping(target = "cantidad", source = "cantidad")
    ProductoConCantidadResponse toResponse(Producto producto, int cantidad);

}