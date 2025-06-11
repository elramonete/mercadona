package com.product.mercadona.domain.repository;

import com.product.mercadona.domain.CestaDeCompra;
import com.product.mercadona.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CestaCompraRepository extends JpaRepository<CestaDeCompra, Long> {

    Optional<CestaDeCompra> findByClienteId(Long clienteId);
}
