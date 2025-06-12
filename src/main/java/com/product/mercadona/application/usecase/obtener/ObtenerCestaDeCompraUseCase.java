package com.product.mercadona.application.usecase.obtener;

import com.product.mercadona.application.dto.CestaDeCompraResponse;
import com.product.mercadona.application.mapper.ProductoMapper;
import com.product.mercadona.domain.CestaDeCompra;
import com.product.mercadona.domain.repository.CestaCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ObtenerCestaDeCompraUseCase {
    private final CestaCompraRepository cestaDeCompraRepository;

    @Autowired
    public ObtenerCestaDeCompraUseCase(@Qualifier("cestaCompraJpaRepository") CestaCompraRepository cestaDeCompraRepository) {
        this.cestaDeCompraRepository = cestaDeCompraRepository;
    }

    public CestaDeCompraResponse ejecutar(Long clienteId) {
        // Recuperar la cesta de compra del cliente
        CestaDeCompra cestaDeCompra = cestaDeCompraRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cesta de compra no encontrada para el cliente ID: " + clienteId));

        // Convertir los productos desde los ItemCompra
        var productos = cestaDeCompra.getItems().stream()
                .map(item -> ProductoMapper.INSTANCE.toResponse(item.getProducto(), item.getCantidad()))
                .toList();

        // Construir la respuesta
        return CestaDeCompraResponse.builder()
                .id(cestaDeCompra.getId())
                .clienteId(cestaDeCompra.getCliente().getId())
                .productos(productos)
                .total(cestaDeCompra.calcularTotal())
                .build();
    }

}
