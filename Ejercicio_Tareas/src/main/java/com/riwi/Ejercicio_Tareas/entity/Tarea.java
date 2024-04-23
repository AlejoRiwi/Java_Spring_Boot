package com.riwi.Ejercicio_Tareas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

//Definimos la entidad  para mapearla
@Entity
@Table(name = "tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 255,nullable = false)
    private String description;
    @Column (nullable = false)
    private LocalDate fehcaCreacion;
    @Column (nullable =false)
    private LocalDate horaCreacion;

    @Column(length = 50, nullable = false)
    private String estado;
}
