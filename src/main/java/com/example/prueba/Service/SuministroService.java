package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.SuministroEntity;



public interface SuministroService {
	public abstract void insert(SuministroEntity suministro);
	public abstract void update(SuministroEntity suministro);
	public abstract void delete(Integer suministroID );
	public abstract SuministroEntity findById(Integer suministroID);
	public abstract Collection<SuministroEntity>findAll();
}
