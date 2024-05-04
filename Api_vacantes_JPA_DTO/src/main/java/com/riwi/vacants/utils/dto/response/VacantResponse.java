package com.riwi.vacants.utils.dto.response;

import com.riwi.vacants.entities.Company;
import com.riwi.vacants.utils.enums.StatusVacant;



public class VacantResponse {
    private Long id;
    private String title;
    private String description;
    private StatusVacant status;
    private Company company;
}
