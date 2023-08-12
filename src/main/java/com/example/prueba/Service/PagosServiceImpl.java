package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.PagosEntity;
import com.example.prueba.Repository.PagosRepository;






@Service
public class PagosServiceImpl implements PagosService{
	@Autowired
	private PagosRepository pagosRepository;

	@Override
	public void insert(PagosEntity pagos) {
		// TODO Auto-generated method stub
		pagosRepository.save(pagos);
	}

	@Override
	public void update(PagosEntity pagos) {
		// TODO Auto-generated method stub
		pagosRepository.save(pagos);
		
	}

	@Override
	public void delete(Integer pagoId) {
		// TODO Auto-generated method stub
		pagosRepository.deleteById(pagoId);
		
	}

	@Override
	public PagosEntity findById(Integer pagoId) {
		// TODO Auto-generated method stub
		return pagosRepository.findById(pagoId).orElse(null);
	}

	@Override
	public Collection<PagosEntity> findAll() {
		// TODO Auto-generated method stub
		return pagosRepository.findAll();
	}
}
