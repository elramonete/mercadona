package com.product.mercadona.application.usecase.obtener;


import com.product.mercadona.application.dto.CestaDeCompraResponse;
import com.product.mercadona.application.mapper.ProductoMapper;
import com.product.mercadona.domain.CestaDeCompra;
import com.product.mercadona.domain.repository.CestaCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ObtenerCestaDeCompraUseCase {
    private final CestaCompraRepository cestaDeCompraRepository;
    @Autowired
    public ObtenerCestaDeCompraUseCase(CestaCompraRepository cestaDeCompraRepository) {
        this.cestaDeCompraRepository = cestaDeCompraRepository;
    }
    public CestaDeCompraResponse ejecutar(Long clienteId) {
        // Recuperar la cesta de compra del cliente
        CestaDeCompra cestaDeCompra = cestaDeCompraRepository.findByClienteId(clienteId);
        if (cestaDeCompra == null) {
            throw new IllegalArgumentException("Cesta de compra no encontrada para el cliente ID: " + clienteId);
        }
        // Convertir la cesta de compra a su representación DTO
        return CestaDeCompraResponse.builder()
                .id(cestaDeCompra.getId())
                .clienteId(cestaDeCompra.getCliente().getId())
                .productos(cestaDeCompra.getProductos().stream()
                        .map(producto -> ProductoMapper.INSTANCE.toResponse(producto)) // Usando el mapper para convertir productos
                        .toList())
                .total(cestaDeCompra.calcularTotal()) // Calcular el total de la cesta
                .build();
    }
}
