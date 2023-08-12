package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.PagosEntity;







public interface PagosService {
	
	public abstract void insert(PagosEntity pagos);
	public abstract void update(PagosEntity pagos);
	public abstract void delete(Integer pagoID );
	public abstract PagosEntity findById(Integer pagoID);
	public abstract Collection<PagosEntity>findAll();

}
