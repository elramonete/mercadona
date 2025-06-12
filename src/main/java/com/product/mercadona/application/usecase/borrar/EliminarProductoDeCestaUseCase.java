package com.product.mercadona.application.usecase.borrar;

import com.product.mercadona.application.dto.CestaDeCompraCommand;
import com.product.mercadona.application.dto.ProductoCantidadDTO;
import com.product.mercadona.domain.CestaDeCompra;
import com.product.mercadona.domain.Producto;
import com.product.mercadona.domain.repository.CestaCompraRepository;
import com.product.mercadona.domain.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EliminarProductoDeCestaUseCase {

    private final CestaCompraRepository cestaDeCompraRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public EliminarProductoDeCestaUseCase(@Qualifier("cestaCompraJpaRepository") CestaCompraRepository cestaDeCompraRepository,
                                          ProductoRepository productoRepository) {
        this.cestaDeCompraRepository = cestaDeCompraRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional
    public void ejecutar(CestaDeCompraCommand cestaDeCompraCommand) {
        CestaDeCompra cestaDeCompra = cestaDeCompraRepository.findByClienteId(cestaDeCompraCommand.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cesta de compra no encontrada para el cliente ID: " + cestaDeCompraCommand.getClienteId()));

        // Obtener los IDs de productos a eliminar
        var productoIdsAEliminar = cestaDeCompraCommand.getProductos().stream()
                .map(ProductoCantidadDTO::getProductoId)
                .toList();

        // Eliminar los items de la cesta que coincidan con esos IDs
        cestaDeCompra.getItems().removeIf(item ->
                productoIdsAEliminar.contains(item.getProducto().getId())
        );

        cestaDeCompraRepository.save(cestaDeCompra);
    }


}
