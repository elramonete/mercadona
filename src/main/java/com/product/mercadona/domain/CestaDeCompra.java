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

    @OneToMany(mappedBy = "cestaDeCompra", cascade = CascadeType.ALL, orphanRemoval = true)
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

    // Método para establecer el cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Método para eliminar un producto de la cesta
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    // Método para obtener los IDs de los productos en la cesta
    public List<Long> getProductoIds() {
        List<Long> productoIds = new ArrayList<>();
        for (Producto producto : productos) {
            productoIds.add(producto.getId());
        }
        return productoIds;
    }
}
