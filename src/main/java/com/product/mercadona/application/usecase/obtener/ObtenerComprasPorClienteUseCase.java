package com.product.mercadona.application.usecase.obtener;
import com.product.mercadona.application.dto.ItemCompraResponse;
import com.product.mercadona.domain.ItemCompra;
import com.product.mercadona.domain.repository.ItemCompraRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ObtenerComprasPorClienteUseCase {
    private final ItemCompraRepository itemCompraRepository;
    public ObtenerComprasPorClienteUseCase(ItemCompraRepository itemCompraRepository) {
        this.itemCompraRepository = itemCompraRepository;
    }
    public List<ItemCompraResponse> ejecutar(Long clienteId) {
        // Recuperar todas las compras del cliente
        List<ItemCompra> itemsComprados = itemCompraRepository.findByClienteId(clienteId);
        // Convertir los items de compra a DTOs
        return itemsComprados.stream()
                .map(this::toResponse) // Convertir cada ItemCompra a ItemCompraResponse
                .collect(Collectors.toList());
    }
    private ItemCompraResponse toResponse(ItemCompra itemCompra) {
        return ItemCompraResponse.builder()
                .id(itemCompra.getId())
                .clienteId(itemCompra.getCliente().getId()) // Obtener el ID del cliente
                .productoId(itemCompra.getProducto().getId()) // Obtener el ID del producto
                .cantidad(itemCompra.getCantidad())
                .build();
    }
}