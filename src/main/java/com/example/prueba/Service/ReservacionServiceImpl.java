package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.Entity.ReservacionEntity;
import com.example.prueba.Repository.ReservacionRepository;
@Service
public class ReservacionServiceImpl implements ReservacionService{
	@Autowired
	private ReservacionRepository reservacionrepository;

	@Override
	public void insert(ReservacionEntity reservacion) {
		reservacionrepository.save(reservacion);
		
	}

	@Override
	public void update(ReservacionEntity reservacion) {
		// TODO Auto-generated method stub
		reservacionrepository.save(reservacion);
		
	}

	@Override
	public void delete(Integer reservacionID) {
		reservacionrepository.deleteById(reservacionID);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ReservacionEntity findById(Integer reservacionID) {
		// TODO Auto-generated method stub
		return reservacionrepository.findById(reservacionID).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<ReservacionEntity> findAll() {
		// TODO Auto-generated method stub
		return reservacionrepository.findAll();
	}

}
