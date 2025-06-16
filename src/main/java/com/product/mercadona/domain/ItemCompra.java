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
    @ManyToOne
    @JoinColumn(name = "cesta_id") // Columna que referencia al cestaDeCompra
    private CestaDeCompra cestaDeCompra;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItemCompra{");
        sb.append("id=").append(id);
        sb.append(", cliente=").append(cliente);
        sb.append(", producto=").append(producto);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", cestaDeCompra=").append(cestaDeCompra);
        sb.append('}');
        return sb.toString();
    }
}
