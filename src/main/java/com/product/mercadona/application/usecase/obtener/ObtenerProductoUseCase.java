package com.product.mercadona.application.usecase.obtener;

import com.product.mercadona.application.dto.ProductoResponse;
import com.product.mercadona.application.exception.cliente.ClienteNotFoundException;
import com.product.mercadona.application.exception.producto.ProductoNotFoundException;
import com.product.mercadona.application.mapper.ClienteMapper;
import com.product.mercadona.application.mapper.ProductoMapper;
import com.product.mercadona.domain.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObtenerProductoUseCase {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoResponse> obtenerTodosLosProductos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProductoResponse obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .map(productoMapper::toResponse)
                .orElseThrow(() -> new ProductoNotFoundException("Product not found with ID: " + id));
    }
}
