package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.HabitacionEntity;
import com.example.prueba.Repository.HabitacionRepository;
@Service
public class HabitacionServiceImpl implements HabitacionService{
	@Autowired
	private HabitacionRepository habitacionrepository;

	@Override
	public void insert(HabitacionEntity habitacion) {
		// TODO Auto-generated method stub
		habitacionrepository.save(habitacion);
	}

	@Override
	public void update(HabitacionEntity habitacion) {
		// TODO Auto-generated method stub
		habitacionrepository.save(habitacion);
	}

	@Override
	public void delete(Integer habitacionID) {
		// TODO Auto-generated method stub
		habitacionrepository.deleteById(habitacionID);
	}

	@Override
	public HabitacionEntity findById(Integer habitacionID) {
		// TODO Auto-generated method stub
		return habitacionrepository.findById(habitacionID).orElse(null);
	}

	@Override
	public Collection<HabitacionEntity> findAll() {
		// TODO Auto-generated method stub
		return habitacionrepository.findAll();
	}

}
