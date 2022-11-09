package com.kodlamaIO.programs.business.abstracts;

import java.util.List;

import com.kodlamaIO.programs.business.responses.Technology.GetAllTechnologiesResponse;

public interface TechnologyServices {
    List<GetAllTechnologiesResponse> getAll();
}
