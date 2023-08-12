package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.Entity.TipoHabitacionEntity;
import com.example.prueba.Repository.TipoHabitacionRepository;

@Service
public class TipoHabitacionServiceImpl implements TipoHabitacionService{
	@Autowired
	private TipoHabitacionRepository tipohabitacionrepository;

	@Override
	public void insert(TipoHabitacionEntity tipohabitacion) {
		tipohabitacionrepository.save(tipohabitacion);
		
	}

	@Override
	public void update(TipoHabitacionEntity tipohabitacion) {
		tipohabitacionrepository.save(tipohabitacion);
		
	}

	@Override
	public void delete(Integer tipohabitacionID) {
		tipohabitacionrepository.deleteById(tipohabitacionID);
		
	}

	@Override
	@Transactional(readOnly = true)
	public TipoHabitacionEntity findById(Integer tipohabitacionID) {
		// TODO Auto-generated method stub
		return tipohabitacionrepository.findById(tipohabitacionID).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TipoHabitacionEntity> findAll() {
		// TODO Auto-generated method stub
		return tipohabitacionrepository.findAll();
	}

}
