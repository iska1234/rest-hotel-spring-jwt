package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.RegistroSalidaSuministros;



public interface RegistroSalidaSuministroService {
	public abstract void insert(RegistroSalidaSuministros registrosalidasuministros);
	public abstract void update(RegistroSalidaSuministros registrosalidasuministros);
	public abstract void delete(Integer registrosalidasuministrosID );
	public abstract RegistroSalidaSuministros findById(Integer registrosalidasuministrosID);
	public abstract Collection<RegistroSalidaSuministros>findAll();

}
