package com.riwi.vacants.utils.dto.response;


import com.riwi.vacants.utils.enums.StatusVacant;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantToCompanyResponse {
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusVacant status;
}
