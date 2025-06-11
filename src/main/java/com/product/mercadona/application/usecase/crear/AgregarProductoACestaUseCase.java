package com.product.mercadona.application.usecase.crear;
import com.product.mercadona.application.dto.CestaDeCompraCommand;
import com.product.mercadona.domain.CestaDeCompra;
import com.product.mercadona.domain.Producto;
import com.product.mercadona.domain.repository.CestaCompraRepository;
import com.product.mercadona.domain.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AgregarProductoACestaUseCase {
    private final CestaCompraRepository cestaDeCompraRepository;
    private final ProductoRepository productoRepository;
    public AgregarProductoACestaUseCase(CestaCompraRepository cestaDeCompraRepository,
                                         ProductoRepository productoRepository) {
        this.cestaDeCompraRepository = cestaDeCompraRepository;
        this.productoRepository = productoRepository;
    }
    @Transactional
    public void ejecutar(CestaDeCompraCommand cestaDeCompraCommand) {
        // Recuperar la cesta de compra del cliente
        CestaDeCompra cestaDeCompra = cestaDeCompraRepository.findByClienteId(cestaDeCompraCommand.getClienteId());

        if (cestaDeCompra == null) {
            // Si no existe una cesta, podrías crear una nueva o lanzar una excepción
            throw new IllegalArgumentException("Cesta de compra no encontrada para el cliente ID: " + cestaDeCompraCommand.getClienteId());
        }
        // Agregar los productos a la cesta
        for (Long productoId : cestaDeCompraCommand.getProductoIds()) {
            Producto producto = productoRepository.findById(productoId)
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productoId));
            cestaDeCompra.agregarProducto(producto);
        }
        // Guardar los cambios en la cesta de compra
        cestaDeCompraRepository.save(cestaDeCompra);
    }
}