package com.kodlamaIO.programs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaIO.programs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{
    
}
