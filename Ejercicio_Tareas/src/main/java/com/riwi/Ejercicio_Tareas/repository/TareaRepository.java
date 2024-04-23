package com.riwi.Ejercicio_Tareas.repository;

import com.riwi.Ejercicio_Tareas.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
