package com.riwi.vacants.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 60, nullable = false)
    private String location;
    @Column(length = 15, nullable = false)
    private String contact;

    // El relacionamiento de unno a muchos en este caso una empresa puede tener muchas vacantes
    // mappedBy debemos especificar en que propuiedad se esta mapeando la otra enditdad
    // Cascade.All Especificamos el tipo de cascada, All Quiere decir que tendra todos los tipos de cascada
    // orphalRemoval especificar que un objeto huerfano (Sin llave foranea) Sera eliminado 
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude  // Excluimos esta propiedad del ToString para evitar un bucle infinito
    @EqualsAndHashCode.Exclude
    private List<Vacant> vacants;
}
