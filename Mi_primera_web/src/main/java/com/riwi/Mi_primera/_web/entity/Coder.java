package com.riwi.Mi_primera._web.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Esta clase sera una entidad y podra ser mapeada
@Entity
@Table(name = "coder")
public class Coder {

    @Id // Indica que el atributo siguiente sera la llave primaria en este caso es el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Recibe lo que es una estrategia de generacion de valores para que el ID se auto incremente automaticamente 
    private Long id;
    private String name;
    private String age;
    private String clan;

    public Coder() {
    }

    public Coder(Long id, String name, String age, String clan) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clan = clan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "Coder [id=" + id + ", name=" + name + ", age=" + age + ", clan=" + clan + "]";
    }
}
