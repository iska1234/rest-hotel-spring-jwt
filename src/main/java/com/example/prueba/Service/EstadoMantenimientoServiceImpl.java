package com.example.prueba.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.EstadoMantenimientoEntity;
import com.example.prueba.Repository.EstadoMantenimientoRepository;
@Service
public class EstadoMantenimientoServiceImpl implements EstadoMantenimientoService {
	@Autowired
	private EstadoMantenimientoRepository estadomantenimientorepository;

	@Override
	public void insert(EstadoMantenimientoEntity estadomantenimiento) {
		// TODO Auto-generated method stub
		estadomantenimientorepository.save(estadomantenimiento);
		
	}

	@Override
	public void update(EstadoMantenimientoEntity estadomantenimiento) {
		// TODO Auto-generated method stub
		estadomantenimientorepository.save(estadomantenimiento);
		
	}

	@Override
	public void delete(Integer estadomantenimientoID) {
		// TODO Auto-generated method stub
		estadomantenimientorepository.deleteById(estadomantenimientoID);
	}

	@Override
	public EstadoMantenimientoEntity findById(Integer estadomantenimientoID) {
		// TODO Auto-generated method stub
		return estadomantenimientorepository.findById(estadomantenimientoID).orElse(null);
	}

	@Override
	public Collection<EstadoMantenimientoEntity> findAll() {
		// TODO Auto-generated method stub
		return estadomantenimientorepository.findAll();
	}

	@Override
	public boolean deleteEstadoMantenimiento(Integer estadoID) {
		Optional<EstadoMantenimientoEntity>optionalMantenimiento=estadomantenimientorepository.findById(estadoID);
		if(optionalMantenimiento.isPresent()) {
			EstadoMantenimientoEntity estado= optionalMantenimiento.get();
			estado.setEstado(false);
			estadomantenimientorepository.save(estado);
			return true;
		}else {
		return false;
		}
	}

}
