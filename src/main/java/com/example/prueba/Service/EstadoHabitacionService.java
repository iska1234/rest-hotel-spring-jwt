package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.EstadoHabitacionEntity;



public interface EstadoHabitacionService {
	public abstract void insert(EstadoHabitacionEntity estadohabitacion);
	public abstract void update(EstadoHabitacionEntity estadohabitacion);
	public abstract void delete(Integer estadohabitacionID );
	public abstract EstadoHabitacionEntity findById(Integer estadohabitacionID);
	public abstract Collection<EstadoHabitacionEntity>findAll();
	public boolean deleteEstadoHabitacion(Integer estadoID);

}
