package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.HabitacionEntity;

public interface HabitacionRepository extends JpaRepository<HabitacionEntity, Integer> {

}
