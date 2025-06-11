package com.product.mercadona.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "cesta_id")
    private CestaDeCompra cestaDeCompra; // Referencia a la cesta de compra

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCompra> compras; // Lista de compras en las que está incluido el producto
    // Método para calcular el total de ingresos generados por este producto
    public double calcularIngresos() {
        return compras.stream()
                .mapToDouble(item -> item.getCantidad() * this.precio) // Usando lambda
                .sum();
    }
}