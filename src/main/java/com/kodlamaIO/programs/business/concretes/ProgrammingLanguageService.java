package com.kodlamaIO.programs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIO.programs.business.abstracts.ProgrammingLanguageServices;
import com.kodlamaIO.programs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import com.kodlamaIO.programs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.kodlamaIO.programs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageService implements ProgrammingLanguageServices{
    //Constructor için boş bir repo kaydı oluştur:
    private ProgrammingLanguageRepository programmingLanguageRepository;

    //Constructor olarak her servis için fiziki repo ile boş repoyu eşle:
    @Autowired
    public ProgrammingLanguageService(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }


    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
        ProgrammingLanguage programmingLanguage=new ProgrammingLanguage();
        if (createProgrammingLanguageRequest.getName()==null || createProgrammingLanguageRequest.getName()==""){
            throw new Exception("İsim alanı boş olamaz");
        }
        programmingLanguage.setName(createProgrammingLanguageRequest.getName().toUpperCase());
        this.programmingLanguageRepository.save(programmingLanguage);
        
    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages=programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();
        for (ProgrammingLanguage programmingLanguage: programmingLanguages){
            GetAllProgrammingLanguagesResponse response=new GetAllProgrammingLanguagesResponse();
            response.setName(programmingLanguage.getName());
            response.setId(programmingLanguage.getId());
            programmingLanguagesResponse.add(response);
        }
        return programmingLanguagesResponse;
    }


    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
        //Boş bir dil nesnesi türet:
        ProgrammingLanguage programmingLanguage= new ProgrammingLanguage();
        //Türetilen bu nesnenin id alanını istekten gelen id ile eşle:
        programmingLanguage.setId(deleteProgrammingLanguageRequest.getId());
        //mevcut repositoryden id ile kayıtlı nesneyi sil:
        this.programmingLanguageRepository.delete(programmingLanguage);
    }


    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        ProgrammingLanguage programmingLanguage= new ProgrammingLanguage();
        programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
        programmingLanguage.setName(updateProgrammingLanguageRequest.getName().toUpperCase());
        this.programmingLanguageRepository.save(programmingLanguage);
        
    }
    
    
}
