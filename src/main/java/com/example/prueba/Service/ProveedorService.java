package com.example.prueba.Service;

import java.util.Collection;


import com.example.prueba.Entity.ProveedoresEntity;

public interface ProveedorService {
	public abstract void insert(ProveedoresEntity proveedores);
	public abstract void update(ProveedoresEntity proveedores);
	public abstract void delete(Integer proveedoresID );
	public abstract ProveedoresEntity findById(Integer proveedoresID);
	public abstract Collection<ProveedoresEntity>findAll();
	public boolean deleteProveedor(Integer proveedorID);

}
