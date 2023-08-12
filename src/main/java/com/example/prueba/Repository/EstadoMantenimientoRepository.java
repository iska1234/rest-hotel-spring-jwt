package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.EstadoMantenimientoEntity;

public interface EstadoMantenimientoRepository extends JpaRepository<EstadoMantenimientoEntity, Integer> {

}
