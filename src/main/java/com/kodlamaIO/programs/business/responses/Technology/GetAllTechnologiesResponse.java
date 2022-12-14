package com.kodlamaIO.programs.business.responses.Technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologiesResponse {
    private int id;
    private int programmingLanguageId;
    private String name;
}
