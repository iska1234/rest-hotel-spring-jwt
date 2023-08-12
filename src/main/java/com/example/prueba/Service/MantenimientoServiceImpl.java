package com.example.prueba.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.HuespedEntity;
import com.example.prueba.Entity.MantenimientoEntity;
import com.example.prueba.Repository.MantenimientoRepository;
@Service
public class MantenimientoServiceImpl implements MantenimientoService{
	@Autowired
	private MantenimientoRepository mantenimientorepository;

	@Override
	public void insert(MantenimientoEntity mantenimiento) {
		// TODO Auto-generated method stub
		mantenimientorepository.save(mantenimiento);
	}

	@Override
	public void update(MantenimientoEntity mantenimiento) {
		mantenimientorepository.save(mantenimiento);
		
	}

	@Override
	public void delete(Integer mantenimientoID) {
		mantenimientorepository.deleteById(mantenimientoID);
		
	}

	@Override
	public MantenimientoEntity findById(Integer mantenimientoID) {
		// TODO Auto-generated method stub
		return mantenimientorepository.findById(mantenimientoID).orElse(null);
	}

	@Override
	public Collection<MantenimientoEntity> findAll() {
		// TODO Auto-generated method stub
		return mantenimientorepository.findAll();
	}

	@Override
	public boolean deleteMantenimiento(Integer mantenimientoID) {
		Optional<MantenimientoEntity>optionalMantenimiento=mantenimientorepository.findById(mantenimientoID);
		if(optionalMantenimiento.isPresent()) {
			MantenimientoEntity mantenimiento= optionalMantenimiento.get();
			mantenimiento.setEstado(false);
			mantenimientorepository.save(mantenimiento);
			return true;
		}else {
		return false;
		}
	}

	

	

}
