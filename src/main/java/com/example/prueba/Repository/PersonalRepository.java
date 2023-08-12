package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.PersonalEntity;

public interface PersonalRepository extends JpaRepository<PersonalEntity, Integer> {

}
