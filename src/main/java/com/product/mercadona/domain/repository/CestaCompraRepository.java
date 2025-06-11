package com.product.mercadona.domain.repository;

import com.product.mercadona.domain.CestaDeCompra;
import com.product.mercadona.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CestaCompraRepository extends JpaRepository<CestaDeCompra, Long> {

    CestaDeCompra findByClienteId(Long clienteId);
}
