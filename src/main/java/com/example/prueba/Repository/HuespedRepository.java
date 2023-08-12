package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.HuespedEntity;

public interface HuespedRepository extends JpaRepository<HuespedEntity, Integer> {

}
