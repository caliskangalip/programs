package com.kodlamaIO.programs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.programs.business.concretes.ProgrammingLanguageService;
import com.kodlamaIO.programs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
    //Constructor için servis oluşturulması
    private ProgrammingLanguageService programmingLanguageService;

    //Constructor olarak servisi eşleştirme:
    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    //Tüm dillerin listesini cevap vermek
    @GetMapping("/getAll")
    public List<GetAllProgrammingLanguagesResponse> getAll(){
        return this.programmingLanguageService.getAll();
    }

    //Yeni bir dili eklemek
    @PostMapping("/add")
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{
        this.programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    //Var olan bir dili silmek
    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest){
        this.programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }

    //Var olan dili güncellemek
    @PutMapping("/update")
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        this.programmingLanguageService.update(updateProgrammingLanguageRequest);
    }
}
