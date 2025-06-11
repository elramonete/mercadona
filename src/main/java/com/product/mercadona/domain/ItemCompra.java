package com.product.mercadona.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items_compra")
public class ItemCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id") // Columna que referencia al cliente
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "producto_id") // Columna que referencia al producto
    private Producto producto;
    private int cantidad; // Cantidad del producto comprada
}
