package com.product.mercadona.application.usecase.crear;

import com.product.mercadona.application.dto.ProductoCommand;
import com.product.mercadona.application.dto.ProductoResponse;
import com.product.mercadona.application.mapper.ProductoMapper;
import com.product.mercadona.domain.Producto;
import com.product.mercadona.domain.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CrearProductoUseCase {
    @Autowired
    private ProductoRepository productoRepository;
    public ProductoResponse crearProducto(ProductoCommand productoCommand) {
        Producto producto = ProductoMapper.INSTANCE.toEntity(productoCommand);
        producto = productoRepository.save(producto);
        return ProductoMapper.INSTANCE.toResponse(producto);
    }

}