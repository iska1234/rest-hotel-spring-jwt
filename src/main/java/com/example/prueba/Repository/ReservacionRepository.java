package com.example.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.ReservacionEntity;

public interface ReservacionRepository extends JpaRepository< ReservacionEntity, Integer> {

}
