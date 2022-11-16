package com.kodlamaIO.programs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.kodlamaIO.programs.business.requests.Technology.CreateTechnologyRequest;
import com.kodlamaIO.programs.business.requests.Technology.DeleteTechnologyRequest;
import com.kodlamaIO.programs.business.requests.Technology.UpdateTechnologyRequest;
import org.springframework.stereotype.Service;

import com.kodlamaIO.programs.business.abstracts.TechnologyServices;
import com.kodlamaIO.programs.business.responses.Technology.GetAllTechnologiesResponse;
import com.kodlamaIO.programs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlamaIO.programs.dataAccess.abstracts.TechnologyRepository;
import com.kodlamaIO.programs.entities.concretes.ProgrammingLanguage;
import com.kodlamaIO.programs.entities.concretes.Technology;

@Service
public class TechnologyService implements TechnologyServices{
    private TechnologyRepository technologyRepository;
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public TechnologyService(TechnologyRepository technologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
        this.technologyRepository = technologyRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
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
        ProgrammingLanguage programmingLanguage= programmingLanguageRepository.findById(createTechnologyRequest.getProgrammingLanguageId()).get();
        
        technology.setName(createTechnologyRequest.getName());
        technology.setProgrammingLanguage(programmingLanguage);

        technologyRepository.save(technology);
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        technologyRepository.deleteById(deleteTechnologyRequest.getId());
    }

    @Override
    public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technology=technologyRepository.findById(id).get();
        ProgrammingLanguage programmingLanguage=programmingLanguageRepository.findById(updateTechnologyRequest.getId()).get();

        technology.setName(updateTechnologyRequest.getName());
        technology.setProgrammingLanguage(programmingLanguage);

        technologyRepository.save(technology);
    }
}
