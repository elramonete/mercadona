package com.product.mercadona.application.usecase.crear;

import com.product.mercadona.application.dto.CestaDeCompraCommand;
import com.product.mercadona.domain.CestaDeCompra;
import com.product.mercadona.domain.Cliente;
import com.product.mercadona.domain.ItemCompra;
import com.product.mercadona.domain.Producto;
import com.product.mercadona.domain.repository.CestaCompraRepository;
import com.product.mercadona.domain.repository.ClienteRepository;
import com.product.mercadona.domain.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AgregarProductoACestaUseCase {
    private final CestaCompraRepository cestaDeCompraRepository;
    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;

    public AgregarProductoACestaUseCase(@Qualifier("cestaCompraJpaRepository") CestaCompraRepository cestaDeCompraRepository,
                                        ProductoRepository productoRepository,
                                        ClienteRepository clienteRepository) {
        this.cestaDeCompraRepository = cestaDeCompraRepository;
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public void ejecutar(CestaDeCompraCommand cestaDeCompraCommand) {
        // Recuperar o crear la cesta de compra del cliente
        CestaDeCompra cestaDeCompra = cestaDeCompraRepository.findByClienteId(cestaDeCompraCommand.getClienteId())
                .orElseGet(() -> crearNuevaCesta(cestaDeCompraCommand.getClienteId()));

        Cliente cliente = cestaDeCompra.getCliente();

        // Agregar los productos a la cesta como ItemCompra con cantidad
        cestaDeCompraCommand.getProductos().forEach(dto -> {
            Producto producto = productoRepository.findById(dto.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + dto.getProductoId()));

            // Buscar si el producto ya existe en la cesta
            ItemCompra itemExistente = cestaDeCompra.getItems().stream()
                    .filter(item -> item.getProducto().getId().equals(dto.getProductoId()))
                    .findFirst()
                    .orElse(null);

            if (itemExistente != null) {
                // Si el producto ya existe, sumar la cantidad
                itemExistente.setCantidad(itemExistente.getCantidad() + dto.getCantidad());
            } else {
                // Si el producto no existe, crear un nuevo ItemCompra
                ItemCompra nuevoItem = new ItemCompra();
                nuevoItem.setProducto(producto);
                nuevoItem.setCliente(cliente);
                nuevoItem.setCestaDeCompra(cestaDeCompra);
                nuevoItem.setCantidad(dto.getCantidad());

                cestaDeCompra.agregarItem(nuevoItem);
            }
        });

        // Guardar los cambios en la cesta de compra
        cestaDeCompraRepository.save(cestaDeCompra);
    }




    private CestaDeCompra crearNuevaCesta(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + clienteId));
        CestaDeCompra nuevaCesta = new CestaDeCompra();
        nuevaCesta.setCliente(cliente);
        cestaDeCompraRepository.save(nuevaCesta);
        return nuevaCesta;
    }
}
