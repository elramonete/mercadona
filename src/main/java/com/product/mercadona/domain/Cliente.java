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
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    @Embedded
    private Email email; // Email embebido como un objeto
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCompra> compras; // Lista de compras realizadas por el cliente
    // Método para agregar una compra
    public void agregarCompra(ItemCompra itemCompra) {
        compras.add(itemCompra);
        itemCompra.setCliente(this); // Establece el cliente en el itemCompra
    }
}
