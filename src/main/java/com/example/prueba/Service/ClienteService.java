package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.ClienteEntity;






public interface ClienteService {
	
	public abstract void insert(ClienteEntity cliente);
	public abstract void update(ClienteEntity cliente);
	public abstract void delete(Integer clienteID );
	public abstract ClienteEntity findById(Integer clienteID);
	public abstract Collection<com.example.prueba.Entity.ClienteEntity>findAll();


}
