package com.example.demo.adoption.infrastructure; //java adds this automatically, shows the location of this file

import org.springframework.data.jpa.repository.JpaRepository;//contains built in commands like • save(), saveAll(), findById(), findAll(), deleteById().

import org.springframework.stereotype.Repository;//tells spring boot to talk to the database

@Repository
//the @ declares an -Annotation/or it acts as a sticky note and combined with the Repository it tells us that its a tool to command the database

//JpaRepository means it inherits all the database powers.
//Long is the long numer of the ID and manages the AdoptionApplicationEntity table
//
public interface AdoptionApplicationRepository extends JpaRepository<AdoptionApplicationEntity, Long> {
    
}