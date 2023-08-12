package com.example.prueba.Service;

import java.util.Collection;


import com.example.prueba.Entity.RegistroEntradaSuministroEntity;

public interface RegistroEntradaSuministrosService {
	public abstract void insert(RegistroEntradaSuministroEntity registroentradasuministro);
	public abstract void update(RegistroEntradaSuministroEntity registroentradasuministro);
	public abstract void delete(Integer registroentradasuministroID );
	public abstract RegistroEntradaSuministroEntity findById(Integer registroentradasuministroID);
	public abstract Collection<RegistroEntradaSuministroEntity>findAll();


}
