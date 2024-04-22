package com.riwi.operaciones.controller;

import com.riwi.operaciones.entities.Operations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {
    @PostMapping(path = "/suma")
    public String suma(@RequestBody Operations objOperations) {
        String message = String.valueOf(objOperations.getNum1() + objOperations.getNum2());
        return objOperations.getNum1() + " + " + objOperations.getNum2() + " = " +message;
    }
    @PostMapping(path = "/resta")
    public String resta(@RequestBody Operations objOperations) {
        String message = String.valueOf(objOperations.getNum1() - objOperations.getNum2());
        return objOperations.getNum1() + " - " + objOperations.getNum2() + " = " +message;
    }
    @PostMapping(path = "/multiplicacion")
    public String multiplicacion(@RequestBody Operations objOperations) {
        String message = String.valueOf(objOperations.getNum1() * objOperations.getNum2());
        return objOperations.getNum1() + " + " + objOperations.getNum2() + " = " +message;
    }

    @PostMapping(path = "/division")
    public String division(@RequestBody Operations objOperations) {
        String message;
        if (objOperations.getNum2() == 0) {
            return "No se puede dividir numeros entre 0";
        } else {
           message = String.valueOf(objOperations.getNum1() / objOperations.getNum2());
        }

        return objOperations.getNum1() + " / " + objOperations.getNum2() + " = " +message;
    }

}
