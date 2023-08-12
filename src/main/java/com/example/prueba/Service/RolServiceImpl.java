package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.RolEntity;
import com.example.prueba.Repository.RolRepository;
@Service
public class RolServiceImpl implements RolService{
	@Autowired
	private RolRepository rolrepository;

	@Override
	@Transactional
	public void insert(RolEntity rol) {
		rolrepository.save(rol);
		
	}

	@Override
	public void update(RolEntity rol) {
		rolrepository.save(rol);	
	}

	@Override
	public void delete(Integer rolID) {
		rolrepository.deleteById(rolID);
		
	}

	@Override
	@Transactional(readOnly = true)
	public RolEntity findById(Integer rolID) {
		// TODO Auto-generated method stub
		return rolrepository.findById(rolID).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<RolEntity> findAll() {
		// TODO Auto-generated method stub
		return rolrepository.findAll();
	}

}
