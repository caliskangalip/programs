package com.kodlamaIO.programs.business.abstracts;

import java.util.List;

import com.kodlamaIO.programs.business.requests.Technology.CreateTechnologyRequest;
import com.kodlamaIO.programs.business.requests.Technology.DeleteTechnologyRequest;
import com.kodlamaIO.programs.business.requests.Technology.UpdateTechnologyRequest;
import com.kodlamaIO.programs.business.responses.Technology.GetAllTechnologiesResponse;

public interface TechnologyServices {
    List<GetAllTechnologiesResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest);
    void delete(DeleteTechnologyRequest deleteTechnologyRequest);
    void update(UpdateTechnologyRequest updateTechnologyRequest);
}
