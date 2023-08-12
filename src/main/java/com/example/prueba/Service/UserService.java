package com.example.prueba.Service;

import java.util.Collection;
import java.util.Set;

import com.example.prueba.Entity.RolEntity;
import com.example.prueba.Entity.UserEntity;
import com.example.prueba.Formularios.ClienteDto;
import com.example.prueba.Formularios.PersonalDto;



public interface UserService {
	public abstract UserEntity findById(Integer userID);
	public abstract Collection<UserEntity>findAll();
	public abstract Collection<Object[]> findAll_withUser();
	public abstract UserEntity findByEmail(String email);
	public void crearUsuarioYCliente(ClienteDto clienteDto);
	public void crearUsuarioYPersonal(PersonalDto personalDto);
	public abstract void save(UserEntity user);
	void addRoleToUser(Integer userId, Set<RolEntity> roles);
	

}
