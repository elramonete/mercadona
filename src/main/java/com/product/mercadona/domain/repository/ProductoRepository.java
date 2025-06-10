package com.product.mercadona.domain.repository;

import com.product.mercadona.domain.Cliente;
import com.product.mercadona.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface ProductoRepository extends JpaRepository <Producto, Long> {


}
