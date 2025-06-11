package com.product.mercadona.domain.repository;

import com.product.mercadona.domain.Cliente;
import com.product.mercadona.domain.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {

    List<ItemCompra> findByClienteId(Long clienteId);
}
