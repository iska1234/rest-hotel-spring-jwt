package com.example.prueba.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.prueba.Entity.PersonalEntity;
import com.example.prueba.Repository.PersonalRepository;
@Service
public class PersonalServiceImpl implements PersonalService {
	@Autowired
	private PersonalRepository personalrepository;

	@Override
	public void insert(PersonalEntity personal) {
		// TODO Auto-generated method stub
		personalrepository.save(personal);
		
	}

	@Override
	public void update(PersonalEntity personal) {
		// TODO Auto-generated method stub
		personalrepository.save(personal);
	}

	@Override
	public void delete(Integer personalID) {
		// TODO Auto-generated method stub
		personalrepository.deleteById(personalID);
	}

	@Override
	public PersonalEntity findById(Integer personalID) {
		// TODO Auto-generated method stub
		return personalrepository.findById(personalID).orElse(null);
	}

	@Override
	public Collection<PersonalEntity> findAll() {
		// TODO Auto-generated method stub
		return personalrepository.findAll();
	}

	@Override
	public boolean deletePersonal(Integer personalID) {
		Optional<PersonalEntity>optionalPersonal=personalrepository.findById(personalID);
		if(optionalPersonal.isPresent()) {
			PersonalEntity personal= optionalPersonal.get();
			personal.setEstado(false);
			personalrepository.save(personal);
			return true;
		}else {
		return false;
		}
	}

}
