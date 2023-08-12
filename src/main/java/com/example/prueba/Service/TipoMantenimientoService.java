package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.TipoMantenimientoEntity;



public interface TipoMantenimientoService {
	public abstract void insert(TipoMantenimientoEntity tipomantenimiento);
	public abstract void update(TipoMantenimientoEntity tipomantenimiento);
	public abstract void delete(Integer tipomantenimientoID );
	public abstract TipoMantenimientoEntity findById(Integer tipomantenimientoID);
	public abstract Collection<TipoMantenimientoEntity>findAll();
}
