package com.product.mercadona.application.usecase.borrar;

import com.product.mercadona.application.dto.CestaDeCompraCommand;
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
        // Recuperar la cesta de compra del cliente
        CestaDeCompra cestaDeCompra = cestaDeCompraRepository.findByClienteId(cestaDeCompraCommand.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cesta de compra no encontrada para el cliente ID: " + cestaDeCompraCommand.getClienteId()));

        // Eliminar los productos de la cesta utilizando una expresión lambda
        cestaDeCompraCommand.getProductoIds().forEach(productoId -> {
            Producto producto = productoRepository.findById(productoId)
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productoId));
            cestaDeCompra.eliminarProducto(producto);
        });

        // Guardar los cambios en la cesta de compra
        cestaDeCompraRepository.save(cestaDeCompra);
    }
}
