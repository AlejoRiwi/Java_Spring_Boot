package com.riwi.Mi_primera._web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.riwi.Mi_primera._web.entity.Coder;
import com.riwi.Mi_primera._web.services.CoderService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")

public class CoderController {
    @Autowired
    private CoderService objCoderService;

    /*
     * Metodo para mostrar la vista y enviar los datos
     */
    @GetMapping
    public String showViewGetAll(Model objModel, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {

        // Se llama el servicio y se cuarda en la lista de coders
        Page<Coder> list = objCoderService.findPaginated(page - 1,size);
        objModel.addAttribute("coderList", list);
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPages", list.getTotalPages());

        // Se debe de retornar el nombre exacto de la vista HTML
        return "ViewCode";
    }

    @GetMapping("/form")
    public String showFromCoder(Model objModel) {
        objModel.addAttribute("coder", new Coder());
        objModel.addAttribute("action", "/coder/create");
        return "ViewForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteCoder(@PathVariable Long id) {
        this.objCoderService.delete(id);
        return "redirect:/";
    }


    /*
    MEtodo para insertar un coder mediante el metodo PostMapping
    @modelAttribute se encarga de optener informacion enviada desde la vista o HTML
     */
    @PostMapping("/coder/create") // para recibir informacion de la vista
    public String createCoder(@ModelAttribute Coder objCoder) {
        // Llamamos al servicio enviandole el coder a insertar
        this.objCoderService.insert(objCoder);

        return "redirect:/";
    }


    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Long id, Model objModel){
        Coder objCoderFind = this.objCoderService.findById(id);
        objModel.addAttribute("coder", objCoderFind);
        objModel.addAttribute("action", "/edit/" + id);
        return "ViewForm";
    }

    @PostMapping("/update/{id}")
    public String crearCoder(@ModelAttribute Long id, Coder objCoder){
        this.objCoderService.update(id, objCoder);

        return  "redirect:/";
    }
}
