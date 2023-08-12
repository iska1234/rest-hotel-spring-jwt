package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.RegistroSalidaHuespedesEntity;
import com.example.prueba.Repository.RegistroSalidaHuespedRepository;
@Service
public class RegistroSalidaHuespedServiceImpl implements RegistroSalidaHuespedService {
	@Autowired
	private RegistroSalidaHuespedRepository registrosalidahuespedrepository;

	@Override
	public void insert(RegistroSalidaHuespedesEntity registrosalidahuesped) {
		// TODO Auto-generated method stub
		registrosalidahuespedrepository.save(registrosalidahuesped);
	}

	@Override
	public void update(RegistroSalidaHuespedesEntity registrosalidahuesped) {
		// TODO Auto-generated method stub
		registrosalidahuespedrepository.save(registrosalidahuesped);
	}

	@Override
	public void delete(Integer registrosalidahuespedID) {
		// TODO Auto-generated method stub
		registrosalidahuespedrepository.deleteById(registrosalidahuespedID);
	}

	@Override
	public RegistroSalidaHuespedesEntity findById(Integer registrosalidahuespedID) {
		// TODO Auto-generated method stub
		return registrosalidahuespedrepository.findById(registrosalidahuespedID).orElse(null);
	}

	@Override
	public Collection<RegistroSalidaHuespedesEntity> findAll() {
		// TODO Auto-generated method stub
		return registrosalidahuespedrepository.findAll();
	}

}
