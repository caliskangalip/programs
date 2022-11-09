package com.kodlamaIO.programs.business.concretes;

import java.util.List;

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
        List<TechnologyRepository> technologyRepositories=technologyRepository.findAll();
        List<GetAllTechnologiesResponse> technologiesResponses=new GetAllTechnologiesResponse();
        for (Technology technology:technologyRepositories){
            GetAllTechnologiesResponse response=new GetAllTechnologiesResponse();
            response.setId(technology.getId());
            response.setProgrammingLanguageId(technology.getProgrammingLanguage());
            response.setName(technology.getName());
        }
        return null;
    }
    
}
