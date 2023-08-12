package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.TipoHabitacionEntity;



public interface TipoHabitacionService {
	public abstract void insert(TipoHabitacionEntity tipohabitacion);
	public abstract void update(TipoHabitacionEntity tipohabitacion);
	public abstract void delete(Integer tipohabitacionID );
	public abstract TipoHabitacionEntity findById(Integer tipohabitacionID);
	public abstract Collection<TipoHabitacionEntity>findAll();

}
