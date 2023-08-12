package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.PersonalEntity;



public interface PersonalService {
	public abstract void insert(PersonalEntity personal);
	public abstract void update(PersonalEntity personal);
	public abstract void delete(Integer personalID );
	public abstract PersonalEntity findById(Integer personalID);
	public abstract Collection<PersonalEntity>findAll();
	public boolean deletePersonal(Integer personalID);

}
