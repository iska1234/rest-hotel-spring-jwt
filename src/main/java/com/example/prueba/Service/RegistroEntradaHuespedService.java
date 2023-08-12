package com.example.prueba.Service;

import java.util.Collection;


import com.example.prueba.Entity.RegistroEntradaHuespedesEntity;

public interface RegistroEntradaHuespedService {
	public abstract void insert(RegistroEntradaHuespedesEntity registrohuesped);
	public abstract void update(RegistroEntradaHuespedesEntity registrohuesped);
	public abstract void delete(Integer registrohuespedID );
	public abstract RegistroEntradaHuespedesEntity findById(Integer registrohuespedID);
	public abstract Collection<RegistroEntradaHuespedesEntity>findAll();


}
