package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.RegistroEntradaSuministroEntity;
import com.example.prueba.Repository.RegistroEntradaSuministroRepository;
@Service
public class RegistroEntradaSuministrosServiceImpl implements RegistroEntradaSuministrosService{
	@Autowired
	private RegistroEntradaSuministroRepository registroentradasuministrorepository;

	@Override
	public void insert(RegistroEntradaSuministroEntity registroentradasuministro) {
		// TODO Auto-generated method stub
		registroentradasuministrorepository.save(registroentradasuministro);
	}

	@Override
	public void update(RegistroEntradaSuministroEntity registroentradasuministro) {
		// TODO Auto-generated method stub
		registroentradasuministrorepository.save(registroentradasuministro);
	}

	@Override
	public void delete(Integer registroentradasuministroID) {
		
		registroentradasuministrorepository.deleteById(registroentradasuministroID);
	}

	@Override
	public RegistroEntradaSuministroEntity findById(Integer registroentradasuministroID) {
		// TODO Auto-generated method stub
		return registroentradasuministrorepository.findById(registroentradasuministroID).orElse(null);
	}

	@Override
	public Collection<RegistroEntradaSuministroEntity> findAll() {
		// TODO Auto-generated method stub
		return registroentradasuministrorepository.findAll();
	}

}
