package com.example.prueba.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prueba.Entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Integer> {
	public abstract RolEntity findByType(String type);
	public abstract Optional<RolEntity> findById(Integer id);

}
