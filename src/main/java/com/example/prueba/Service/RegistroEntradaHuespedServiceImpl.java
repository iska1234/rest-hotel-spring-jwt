package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.RegistroEntradaHuespedesEntity;
import com.example.prueba.Repository.RegistroEntradaHuespedesRepository;

@Service
public class RegistroEntradaHuespedServiceImpl implements RegistroEntradaHuespedService{
	@Autowired
	private RegistroEntradaHuespedesRepository registroentradahuespedrepository;

	@Override
	public void insert(RegistroEntradaHuespedesEntity registrohuesped) {
		// TODO Auto-generated method stub
		registroentradahuespedrepository.save(registrohuesped);
	}

	@Override
	public void update(RegistroEntradaHuespedesEntity registrohuesped) {
		// TODO Auto-generated method stub
		registroentradahuespedrepository.save(registrohuesped);
	}

	@Override
	public void delete(Integer registrohuespedID) {
		// TODO Auto-generated method stub
		registroentradahuespedrepository.deleteById(registrohuespedID);
		
	}

	@Override
	public RegistroEntradaHuespedesEntity findById(Integer registrohuespedID) {
		// TODO Auto-generated method stub
		return registroentradahuespedrepository.findById(registrohuespedID).orElse(null);
	}

	@Override
	public Collection<RegistroEntradaHuespedesEntity> findAll() {
		// TODO Auto-generated method stub
		return registroentradahuespedrepository.findAll();
	}

}
