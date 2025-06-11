package com.product.mercadona.application.usecase.compra;
import com.product.mercadona.application.dto.ItemCompraRequest;
import com.product.mercadona.application.dto.ItemCompraResponse;
import com.product.mercadona.application.mapper.ItemCompraMapper;
import com.product.mercadona.domain.Cliente;
import com.product.mercadona.domain.ItemCompra;
import com.product.mercadona.domain.Producto;
import com.product.mercadona.domain.repository.ClienteRepository;
import com.product.mercadona.domain.repository.ItemCompraRepository;
import com.product.mercadona.domain.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Component
public class RealizarCompraUseCase {
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private final ItemCompraRepository itemCompraRepository;
    private final ItemCompraMapper itemCompraMapper;
    @Autowired
    public RealizarCompraUseCase(ClienteRepository clienteRepository,
                                  ProductoRepository productoRepository,
                                  ItemCompraRepository itemCompraRepository,
                                  ItemCompraMapper itemCompraMapper) {
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
        this.itemCompraRepository = itemCompraRepository;
        this.itemCompraMapper = itemCompraMapper;
    }
    @Transactional
    public List<ItemCompraResponse> ejecutar(Long clienteId, List<ItemCompraRequest> itemCompraRequests) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
        List<ItemCompra> itemsComprados = itemCompraRequests.stream()
                .map(request -> {
                    Producto producto = productoRepository.findById(request.getProductoId())
                            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
                    ItemCompra itemCompra = new ItemCompra();
                    itemCompra.setCliente(cliente);
                    itemCompra.setProducto(producto);
                    itemCompra.setCantidad(request.getCantidad());
                    // Guardar el ItemCompra en la base de datos
                    return itemCompraRepository.save(itemCompra);
                })
                .toList();
        // Mapear a DTOs para la respuesta
        return itemsComprados.stream()
                .map(itemCompraMapper::toResponse)
                .toList();
    }
}