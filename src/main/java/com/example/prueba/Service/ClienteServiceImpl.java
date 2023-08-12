package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.ClienteEntity;
import com.example.prueba.Repository.ClienteRepository;






@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void insert(ClienteEntity cliente) {
		// TODO Auto-generated method stub
		clienteRepository.save(cliente);
	}

	@Override
	public void update(ClienteEntity cliente) {
		// TODO Auto-generated method stub
		clienteRepository.save(cliente);
	}

	@Override
	public void delete(Integer clienteId) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(clienteId);
		
	}

	@Override
	public ClienteEntity findById(Integer clienteId) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(clienteId).orElse(null);
	}

	@Override
	public Collection<ClienteEntity> findAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

}
