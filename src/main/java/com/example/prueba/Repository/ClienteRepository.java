package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

}
