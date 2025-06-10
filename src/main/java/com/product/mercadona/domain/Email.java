package com.product.mercadona.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Embedded;
@Data
@NoArgsConstructor
@Embeddable
public class Email {
    private String email;
    public Email(String email) {
        // Validación de email
        this.email = email;
    }
}
