package com.riwi.products.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity(name = "product")
@Data // Esto se utiliza para crear todos los GET y SETTERS y el TOString
@AllArgsConstructor // Esto se utiliza para generar un Constructor Lleno
@NoArgsConstructor // Esto se utiliza para generar un Constructor Vacio

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String name;
    private int quantity;
    private double price;

    public void setId(Long id) {
        this.id = id;
    }
}
