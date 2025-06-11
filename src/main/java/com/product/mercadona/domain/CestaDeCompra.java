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
    private Cliente cliente; // Cliente asociado a la cesta
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cesta_id") // Columna que referencia a la cesta
    private List<Producto> productos = new ArrayList<>(); // Lista de productos en la cesta
    // Método para agregar un producto a la cesta
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    // Método para calcular el total de la cesta
    public double calcularTotal() {
        return productos.stream()
                .mapToDouble(Producto::getPrecio) // Usando referencia a método
                .sum();
    }

    public void eliminarProducto(Producto producto) {

    }
}
