package com.riwi.vacants.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyToVacantResponse {
    private String id;
    private String name;
    private String location;
    private String contact;
}
