package com.riwi.vacants.services;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.entities.Vacant;
import com.riwi.vacants.repositories.CompanyRepository;
import com.riwi.vacants.services.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompaniyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public CompanyResponse create(CompaniyRequest request) {
        /*
         * Convertimos el request en la entidad
         */
        Company company = this.requestToEntity(request, new Company());
        /*
         * Agregamos la entidad en el repositorio y el retorno lo convertimos 
         * en la respuesta
         */
        return this.entityToResponse(this.companyRepository.save(company));
    }

    @Override
    public void delete(String id) {
        /*
         * Buscamos la compania a la que corresponde el id
         */
        Company company = this.find(id);
        /*
         * Eliminamos
         */
        this.companyRepository.delete(company);
    }

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        /*
         * 1. Se configura la paginacion
         */
        if (page < 0) {
            page = 0;
        }
        PageRequest pagination = PageRequest.of(page, size);

        /*
         * 2. Llamamos el repositorio
         */
        return this.companyRepository.findAll(pagination).map(company -> this.entityToResponse(company));

        /*
         * La misma funcion de arriba se puede hacer de la siguiente manera mas
         * simplificada
         * return
         * this.companyRepository.findAll(pagination).map(this::rentityToResponse);
         */
    }

    @Override
    public CompanyResponse getById(String id) {
        /*Buscamos la compañia con el ID */
        Company company = this.find(id);
        /*Convertimos la entidad al DTO de la respuesta y la retornamos */
        return this.entityToResponse(company);
    }

    @Override
    public CompanyResponse update(CompaniyRequest request, String id) {
        Company companyToUpdate = this.find(id);
        Company company = this.requestToEntity(request, companyToUpdate);

        return this.entityToResponse(this.companyRepository.save(company));
    }

    /*
     * Metodo para convertir de entity a response
     */

    private CompanyResponse entityToResponse(Company entity) {
        CompanyResponse response = new CompanyResponse();

        /*
         * BeanUtils nos permite hacer una copia de una clase en otra
         * En este caso toda la entidad de tipo company sera copiada con la informacion
         * Requerida por la variable tipo CompanyResponse
         */
        BeanUtils.copyProperties(entity, response);
        response.setVacants(
                entity.getVacants().stream().map(vacant -> this.vacantToResponse(vacant)).collect(Collectors.toList()));
        return response;
    }

    private VacantToCompanyResponse vacantToResponse(Vacant entity) {
        VacantToCompanyResponse response = new VacantToCompanyResponse();

        BeanUtils.copyProperties(entity, response);
        return response;
    }

    private Company requestToEntity(CompaniyRequest request, Company company) {

        company.setContact(request.getContact());
        company.setLocation(request.getLocation());
        company.setName(request.getName());
        company.setVacants(new ArrayList<>());
        return company;
    }
y
    private Company find (String id) {
        return this.companyRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Company"));
    }
}
