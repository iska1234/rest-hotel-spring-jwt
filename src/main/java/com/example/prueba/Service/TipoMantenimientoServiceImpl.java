package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.Entity.TipoMantenimientoEntity;
import com.example.prueba.Repository.TipoMantenimientoRepository;
@Service
public class TipoMantenimientoServiceImpl implements TipoMantenimientoService {
	@Autowired
	private TipoMantenimientoRepository tipomantenimientorepository;

	@Override
	public void insert(TipoMantenimientoEntity tipomantenimiento) {
		// TODO Auto-generated method stub
		tipomantenimientorepository.save(tipomantenimiento);
		
	}

	@Override
	public void update(TipoMantenimientoEntity tipomantenimiento) {
		// TODO Auto-generated method stub
		tipomantenimientorepository.save(tipomantenimiento);
		
	}

	@Override
	public void delete(Integer tipomantenimientoID) {
		// TODO Auto-generated method stub
		tipomantenimientorepository.deleteById(tipomantenimientoID);
		
	}

	@Override
	@Transactional(readOnly = true)
	public TipoMantenimientoEntity findById(Integer tipomantenimientoID) {
		// TODO Auto-generated method stub
		return tipomantenimientorepository.findById(tipomantenimientoID).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TipoMantenimientoEntity> findAll() {
		// TODO Auto-generated method stub
		return tipomantenimientorepository.findAll();
	}

}
