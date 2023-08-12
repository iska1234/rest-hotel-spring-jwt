package com.example.prueba.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.HuespedEntity;
import com.example.prueba.Repository.HuespedRepository;
@Service
public class HuespedServiceImpl  implements HuespedService{
	@Autowired
	private HuespedRepository huespedrepository;

	@Override
	public void insert(HuespedEntity huesped) {
		// TODO Auto-generated method stub
		huespedrepository.save(huesped);
	}

	@Override
	public void update(HuespedEntity huesped) {
		// TODO Auto-generated method stub
		huespedrepository.save(huesped);
		
	}

	@Override
	public void delete(Integer huespedID) {
		// TODO Auto-generated method stub
		huespedrepository.deleteById(huespedID);
		
	}

	@Override
	public HuespedEntity findById(Integer huespedID) {
		// TODO Auto-generated method stub
		return huespedrepository.findById(huespedID).orElse(null);
	}

	@Override
	public Collection<HuespedEntity> findAll() {
		// TODO Auto-generated method stub
		return huespedrepository.findAll();
	}

	@Override
	public boolean deleteHuesped(Integer huespedID) {
		Optional<HuespedEntity>optionalHuesped=huespedrepository.findById(huespedID);
		if(optionalHuesped.isPresent()) {
			HuespedEntity huesped= optionalHuesped.get();
			huesped.setEstado(false);
			huespedrepository.save(huesped);
			return true;
		}else {
		return false;
		}
	}

}
