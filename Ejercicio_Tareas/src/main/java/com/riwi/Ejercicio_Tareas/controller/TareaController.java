package com.riwi.Ejercicio_Tareas.controller;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.Ejercicio_Tareas.entity.Tarea;
import com.riwi.Ejercicio_Tareas.services.TareaServices;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/")
public class TareaController {

    @Autowired
    private TareaServices objTareaService;

    @GetMapping
    public String showViewGetAll(ModelMap objModel, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "6") int size) {

        Page<Tarea> pageTarea = objTareaService.findPaginated(page - 1, size);

        objModel.addAttribute("tareas", pageTarea.getContent());
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPages", pageTarea.getTotalPages());

        return "index";
    }
    

    @GetMapping("/form")
    public String showFormTarea(ModelMap objModel) {
        objModel.addAttribute("tarea", new Tarea());
        objModel.addAttribute("action", "/tarea/create");
        return "ViewForm";
    }
    

    @PostMapping("/tarea/create")
    public String createTarea(@ModelAttribute Tarea objTarea) {
        //TODO: process POST request
        this.objTareaService.insert(objTarea);
        return "redirect:/";
    }
    

    @GetMapping("/delete/{id}")
    public String deleteTarea(@PathVariable Long id) {
        this.objTareaService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/ipdate/{id}")
    

}
