package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.EstadoMantenimientoEntity;



public interface EstadoMantenimientoService {
	public abstract void insert(EstadoMantenimientoEntity estadomantenimiento);
	public abstract void update(EstadoMantenimientoEntity estadomantenimiento);
	public abstract void delete(Integer estadomantenimientoID );
	public abstract EstadoMantenimientoEntity findById(Integer estadomantenimientoID);
	public abstract Collection<EstadoMantenimientoEntity>findAll();
	public boolean deleteEstadoMantenimiento(Integer estadoID);

}
