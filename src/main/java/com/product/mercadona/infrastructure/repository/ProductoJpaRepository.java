package com.product.mercadona.infrastructure.repository;


import com.product.mercadona.domain.Producto;
import com.product.mercadona.domain.repository.ProductoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductoJpaRepository extends ProductoRepository {
}

