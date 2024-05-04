package com.riwi.vacants.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.errors.ErrorResponse;
import com.riwi.vacants.utils.dto.errors.ErrorsResponse;
import com.riwi.vacants.utils.dto.request.CompaniyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/company")
@AllArgsConstructor
public class CompanyController {
    @Autowired
    private final ICompanyService companyService;

    @Operation(summary = "Obtiene toda la lista de compañias de forma paginada")
    @GetMapping
    public ResponseEntity <Page<CompanyResponse>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam (defaultValue = "3") int size) {
        return ResponseEntity.ok(this.companyService.getAll(page - 1 , size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse> get(@PathVariable String id) {
        return ResponseEntity.ok(this.companyService.getById(id));
    }

    @ApiResponse(responseCode = "400", description = "Cuando el request no es valido", content = {
        @Content(mediaType = "aplication/json", schema = @Schema(implementation = ErrorsResponse.class))
    })
    @PostMapping
    public ResponseEntity <CompanyResponse> insert (@Validated @RequestBody CompaniyRequest company){
        
        return ResponseEntity.ok(this.companyService.create(company));
    }

    @ApiResponse(responseCode = "400", description = "Cuando el id no es valido", content = {
        @Content(mediaType = "aplication/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id){
        this.companyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiResponse(responseCode = "400", description = "Cuando el request no es valido", content = {
        @Content(mediaType = "aplication/json", schema = @Schema(implementation = ErrorsResponse.class))
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity <CompanyResponse> update (@PathVariable String id, @RequestBody CompaniyRequest company){
        //TODO: process PUT request
        
        return ResponseEntity.ok(this.companyService.update(company, id));
    }
}
