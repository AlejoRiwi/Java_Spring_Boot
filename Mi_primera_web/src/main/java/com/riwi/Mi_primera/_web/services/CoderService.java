package com.riwi.Mi_primera._web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.Mi_primera._web.entity.Coder;
import com.riwi.Mi_primera._web.repository.CoderRepository;

@Service
public class CoderService {

    @Autowired
    private CoderRepository objCoderRepository;

    public List<Coder> findAll(){
        return this.objCoderRepository.findAll();
    }
    public Coder insert(Coder objCoder) {
        return this.objCoderRepository.save(objCoder);
    }

   /* public void delete(Long id){
        return this.objCoderRepository.delete(id);
    }

    */

    // Servicio para actualzar un coder

    public Coder update(Long id, Coder objCoder){
        // Buscar Coder por el ID
        Coder objCoderDB = this.findById(id);

        // Verificar que si existe el coder
        if (objCoderDB == null) return null;

        // Actualizar el coder antiguo
        objCoderDB = objCoder;

        // Guardamos el coder Actualizado
        return this.objCoderRepository.save(objCoderDB);
    }

    public Coder findById(Long id){
        return this.objCoderRepository.findById(id).orElse(null);
    }

    // Metodo para eliminar
    public void delete(Long id) {
        this.objCoderRepository.deleteById(id);
    }


    // Metodo para listar los coders de forma Paginada

    public Page <Coder> findPaginated (int page, int size){
        if (page < 0){
            page = 1;
        }

        // Se crea el objeto de paginacion
        Pageable objPageable= PageRequest.of(page,size);

        return this.objCoderRepository.findAll(objPageable);
    }
}
