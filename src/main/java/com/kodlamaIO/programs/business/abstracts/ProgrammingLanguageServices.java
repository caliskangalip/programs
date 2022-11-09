package com.kodlamaIO.programs.business.abstracts;

import java.util.List;

import com.kodlamaIO.programs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import com.kodlamaIO.programs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;

public interface ProgrammingLanguageServices {
    List<GetAllProgrammingLanguagesResponse> getAll();
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
    void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
}
