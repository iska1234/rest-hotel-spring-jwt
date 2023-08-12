package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.HabitacionEntity;


public interface HabitacionService {
	public abstract void insert(HabitacionEntity habitacion);
	public abstract void update(HabitacionEntity habitacion);
	public abstract void delete(Integer habitacionID );
	public abstract HabitacionEntity findById(Integer habitacionID);
	public abstract Collection<HabitacionEntity>findAll();

}
