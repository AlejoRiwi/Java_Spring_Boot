package com.riwi.Ejercicio_Tareas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.Ejercicio_Tareas.entity.Tarea;
import com.riwi.Ejercicio_Tareas.services.TareaServices;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/")
public class TareaController {
    @Autowired
    private TareaServices objTareaService;

    @PostMapping("/tarea/create")
    public String createTarea(@ModelAttribute Tarea objTarea) {
        //TODO: process POST request
        this.objTareaService.insert(objTarea);
        return "redirect:/";
    }
    
    
    

}
