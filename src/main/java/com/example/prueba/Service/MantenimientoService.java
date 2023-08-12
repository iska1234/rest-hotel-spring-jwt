package com.example.prueba.Service;

import java.util.Collection;


import com.example.prueba.Entity.MantenimientoEntity;

public interface MantenimientoService {
	public abstract void insert(MantenimientoEntity mantenimiento);
	public abstract void update(MantenimientoEntity mantenimiento);
	public abstract void delete(Integer mantenimientoID );
	public abstract MantenimientoEntity findById(Integer mantenimientoID);
	public abstract Collection<MantenimientoEntity>findAll();
	public boolean deleteMantenimiento(Integer mantenimientoID);

}
