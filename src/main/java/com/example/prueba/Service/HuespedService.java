package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.HuespedEntity;



public interface HuespedService {
	public abstract void insert(HuespedEntity huesped);
	public abstract void update(HuespedEntity huesped);
	public abstract void delete(Integer huespedID );
	public abstract HuespedEntity findById(Integer huespedID);
	public abstract Collection<HuespedEntity>findAll();
	public boolean deleteHuesped(Integer huespedID);

}
