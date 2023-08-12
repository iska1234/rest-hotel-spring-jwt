package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.Entity.RegistroSalidaSuministros;
import com.example.prueba.Repository.RegistroSalidaSuministroRepository;
@Service
public class RegistroSalidaSuministroServiceImpl implements RegistroSalidaSuministroService {
	@Autowired
	private RegistroSalidaSuministroRepository registrosalidasuministrorepository;

	@Override
	public void insert(RegistroSalidaSuministros registrosalidasuministros) {
		// TODO Auto-generated method stub
		registrosalidasuministrorepository.save(registrosalidasuministros);
		
	}

	@Override
	public void update(RegistroSalidaSuministros registrosalidasuministros) {
		registrosalidasuministrorepository.save(registrosalidasuministros);
		
	}

	@Override
	public void delete(Integer registrosalidasuministrosID) {
		registrosalidasuministrorepository.deleteById(registrosalidasuministrosID);
		
	}

	@Override
	@Transactional(readOnly = true)
	public RegistroSalidaSuministros findById(Integer registrosalidasuministrosID) {
		// TODO Auto-generated method stub
		return registrosalidasuministrorepository.findById(registrosalidasuministrosID).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<RegistroSalidaSuministros> findAll() {
		// TODO Auto-generated method stub
		return registrosalidasuministrorepository.findAll();
	}

}
