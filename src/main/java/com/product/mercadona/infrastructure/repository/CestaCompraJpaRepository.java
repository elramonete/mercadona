package com.product.mercadona.infrastructure.repository;


import com.product.mercadona.domain.repository.CestaCompraRepository;
import com.product.mercadona.domain.repository.ClienteRepository;
import org.springframework.stereotype.Repository;


@Repository("cestaCompraJpaRepository")
public interface CestaCompraJpaRepository extends CestaCompraRepository {
}

