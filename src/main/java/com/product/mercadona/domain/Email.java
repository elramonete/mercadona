package com.product.mercadona.domain;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Embeddable
public class Email {
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    public Email(String email) {
        setEmail(email); // Usar el setter para aplicar la validación
    }
    public void setEmail(String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }
    private boolean isValid(String email) {
        // Validación simple del formato del email
        return email != null && email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$");
    }
}