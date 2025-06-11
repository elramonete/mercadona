package com.product.mercadona.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Importación correcta
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
   /* El uso de @Embedded en Java, especialmente en frameworks como JPA (Java Persistence API), permite incluir un objeto dentro de una entidad sin que este objeto tenga su propia tabla en la base de datos. Esto es útil para agrupar atributos relacionados en una sola clase y reutilizarla en diferentes entidades.

    En cuanto a tu pregunta sobre el email, usar un objeto Email en lugar de un simple String tiene varias ventajas:

    Encapsulación: Un objeto Email puede encapsular la lógica de validación y formato del email, asegurando que siempre sea válido y esté correctamente formateado.
    Value Object: Separar el email como un objeto independiente sigue el patrón de diseño de Value Object, que ayuda a mantener la integridad y consistencia de los datos.
            Reutilización: Si necesitas usar la misma lógica de validación en diferentes partes de tu aplicación, tener un objeto Email facilita la reutilización.
    Legibilidad: Hace que el código sea más legible y expresivo, ya que el tipo Email comunica claramente la intención del dato*/
    @Embedded
    private Email email;
}
