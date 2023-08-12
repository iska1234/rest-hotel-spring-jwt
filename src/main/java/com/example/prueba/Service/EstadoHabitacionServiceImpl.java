package com.example.prueba.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.EstadoHabitacionEntity;

import com.example.prueba.Repository.EstadoHabitacionRepository;
@Service
public class EstadoHabitacionServiceImpl implements EstadoHabitacionService{
	@Autowired
	private EstadoHabitacionRepository estadohabitacionrepository;

	@Override
	public void insert(EstadoHabitacionEntity estadohabitacion) {
		// TODO Auto-generated method stub
		estadohabitacionrepository.save(estadohabitacion);
	}

	@Override
	public void update(EstadoHabitacionEntity estadohabitacion) {
		// TODO Auto-generated method stub
		estadohabitacionrepository.save(estadohabitacion);
	}

	@Override
	public void delete(Integer estadohabitacionID) {
		// TODO Auto-generated method stub
		estadohabitacionrepository.deleteById(estadohabitacionID);
		
	}

	@Override
	public EstadoHabitacionEntity findById(Integer estadohabitacionID) {
		// TODO Auto-generated method stub
		return estadohabitacionrepository.findById(estadohabitacionID).orElse(null);
	}

	@Override
	public Collection<EstadoHabitacionEntity> findAll() {
		// TODO Auto-generated method stub
		return estadohabitacionrepository.findAll();
	}

	@Override
	public boolean deleteEstadoHabitacion(Integer estadoID) {
		Optional<EstadoHabitacionEntity>optionalEstado=estadohabitacionrepository.findById(estadoID);
		if(optionalEstado.isPresent()) {
			EstadoHabitacionEntity estado= optionalEstado.get();
			estado.setEstado(false);
			estadohabitacionrepository.save(estado);
			return true;
		}else {
		return false;
		}
	}

	

}
