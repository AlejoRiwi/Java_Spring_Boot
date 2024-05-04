package com.riwi.vacants.utils.exceptions;


/*
 * RutimeException es la clase general de errores de JAVA
 * Se utilizara para utilizar su construccion y generar errores 
 */
public class IdNotFoundException extends RuntimeException { 
    private static final String ERROR_MESSGGE = "No hay registros en la entidad %s con el ID subministrado";

    /*Utilizamos el consturctor de  RuntimeException y enviamos el mensaje */

    public IdNotFoundException(String nameEntity) {
        super(String.format(ERROR_MESSGGE, nameEntity));
    }
}
