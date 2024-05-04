package com.riwi.vacants.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // Patron de diseño para crear clases 
@AllArgsConstructor
@NoArgsConstructor
public class CompaniyRequest {
    @Size(min = 0, max = 40, message = "El nombre supera la cantidad de caracteres")
    @NotBlank(message = "El nombre de la compañia es requerido")
    private String name;
    @NotBlank(message = "La locacion de la compañia es requerido")
    private String location;
    @Size(min = 0, max = 15, message = "El contacto supera la cantidad de caracteres")
    @NotBlank(message = "El contacto de la compañia es requerido")
    private String contact;
}
