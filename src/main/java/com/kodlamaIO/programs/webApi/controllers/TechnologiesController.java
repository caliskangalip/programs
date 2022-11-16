package com.kodlamaIO.programs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.programs.business.concretes.TechnologyService;

@RestController
@RequestMapping("(api/technologies")
public class TechnologiesController {
    private TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService){
        this.technologyService=technologyService;
    }
}
