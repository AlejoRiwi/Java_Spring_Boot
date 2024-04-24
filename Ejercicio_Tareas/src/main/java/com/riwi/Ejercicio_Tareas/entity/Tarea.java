package com.riwi.Ejercicio_Tareas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalTime horaCreacion;

    @Column(length = 50, nullable = false)
    private String estado;

    public Tarea() {
    }

    public Tarea(String titulo, String description, LocalDate fehcaCreacion, LocalTime horaCreacion, String estado) {
        this.titulo = titulo;
        this.description = description;
        this.fehcaCreacion = fehcaCreacion;
        this.horaCreacion = horaCreacion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFehcaCreacion() {
        return fehcaCreacion;
    }

    public void setFehcaCreacion(LocalDate fehcaCreacion) {
        this.fehcaCreacion = fehcaCreacion;
    }

    public LocalTime getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(LocalTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", description='" + description + '\'' +
                ", fehcaCreacion=" + fehcaCreacion +
                ", horaCreacion=" + horaCreacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}
