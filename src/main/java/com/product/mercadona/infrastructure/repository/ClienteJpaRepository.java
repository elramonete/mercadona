package com.product.mercadona.infrastructure.repository;


import com.product.mercadona.domain.Cliente;
import com.product.mercadona.domain.repository.ClienteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteJpaRepository extends ClienteRepository {
}

