package com.kodlamaIO.programs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.kodlamaIO.programs.business.requests.Technology.CreateTechnologyRequest;
import com.kodlamaIO.programs.business.requests.Technology.DeleteTechnologyRequest;
import com.kodlamaIO.programs.business.requests.Technology.UpdateTechnologyRequest;
import org.springframework.stereotype.Service;

import com.kodlamaIO.programs.business.abstracts.TechnologyServices;
import com.kodlamaIO.programs.business.responses.Technology.GetAllTechnologiesResponse;
import com.kodlamaIO.programs.dataAccess.abstracts.TechnologyRepository;
import com.kodlamaIO.programs.entities.concretes.Technology;

@Service
public class TechnologyService implements TechnologyServices{
    private TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<Technology> technologyRepositories=technologyRepository.findAll();
        List<GetAllTechnologiesResponse> technologiesResponse=new ArrayList<>();
        for (Technology technology:technologyRepositories){
            GetAllTechnologiesResponse response=new GetAllTechnologiesResponse();
            response.setId(technology.getId());
            response.setName(technology.getName());
            technologiesResponse.add(response);
        }
        return technologiesResponse;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology=new Technology();
        technology.getProgrammingLanguage(createTechnologyRequest.getProgrammingLanguageId());
        technology.setName(createTechnologyRequest.getName());
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {

    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {

    }
}
