package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.PagosEntity;

public interface PagosRepository extends JpaRepository<PagosEntity, Integer> {

}
