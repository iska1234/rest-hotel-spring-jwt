package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.RolEntity;

public interface RolService {
	public abstract void insert(RolEntity rol);
	public abstract void update(RolEntity rol);
	public abstract void delete(Integer rolID );
	public abstract RolEntity findById(Integer rolID);
	public abstract Collection<RolEntity>findAll();

}
