package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.RegistroSalidaHuespedesEntity;



public interface RegistroSalidaHuespedService {
	public abstract void insert(RegistroSalidaHuespedesEntity registrosalidahuesped);
	public abstract void update(RegistroSalidaHuespedesEntity registrosalidahuesped);
	public abstract void delete(Integer registrosalidahuespedID );
	public abstract RegistroSalidaHuespedesEntity findById(Integer registrosalidahuespedID );
	public abstract Collection<RegistroSalidaHuespedesEntity>findAll();

}
