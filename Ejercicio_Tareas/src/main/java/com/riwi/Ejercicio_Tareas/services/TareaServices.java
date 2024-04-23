package com.riwi.Ejercicio_Tareas.services;

import com.riwi.Ejercicio_Tareas.entity.Tarea;
import com.riwi.Ejercicio_Tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServices {

    @Autowired
    private TareaRepository objTareaRepository;

    // Agregar una tarea
    public Tarea insert (Tarea objTarea) {
        return this.objTareaRepository.save(objTarea);
    }

    // Listar todas las Tareas
    public List<Tarea> findAll() {
        return this.objTareaRepository.findAll();
    }

    // Buscar por ID
    public Tarea findById(Long id) {
        return this.objTareaRepository.findById(id).orElse(null);
    }

    // Actualizar tareas
    public Tarea update (Long id, Tarea objTarea) {
        Tarea objTareaId = this.findById(id);
        if (objTareaId == null){
            return null;
        }
        objTareaId = objTarea;
        return this.objTareaRepository.save(objTareaId);
    }

    // Eliminar Tareas
    public void delete (Long id) {
        this.objTareaRepository.deleteById(id);
    }
}
