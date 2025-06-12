package com.product.mercadona.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cestas_de_compra")
public class CestaDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "cestaDeCompra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCompra> items = new ArrayList<>();

    public void agregarItem(ItemCompra item) {
        items.add(item);
        item.setCestaDeCompra(this);
    }

    public void eliminarItem(ItemCompra item) {
        items.remove(item);
        item.setCestaDeCompra(null);
    }

    public double calcularTotal() {
        return items.stream()
                .mapToDouble(item -> item.getCantidad() * item.getProducto().getPrecio())
                .sum();
    }
}
