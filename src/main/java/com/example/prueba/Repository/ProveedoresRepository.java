package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.ProveedoresEntity;

public interface ProveedoresRepository extends JpaRepository<ProveedoresEntity, Integer> {

}
