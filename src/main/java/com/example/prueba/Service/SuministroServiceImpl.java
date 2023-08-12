package com.example.prueba.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.Entity.SuministroEntity;
import com.example.prueba.Repository.SuministroRepository;

@Service
public class SuministroServiceImpl implements SuministroService {
	@Autowired
	private SuministroRepository suministrorepository;

	@Override
	public void insert(SuministroEntity suministro) {
		suministrorepository.save(suministro);
		
	}

	@Override
	public void update(SuministroEntity suministro) {
		suministrorepository.save(suministro);
		
	}

	@Override
	public void delete(Integer suministroID) {
		suministrorepository.deleteById(suministroID);
		
	}

	@Override
	@Transactional(readOnly = true)
	public SuministroEntity findById(Integer suministroID) {
		// TODO Auto-generated method stub
		return suministrorepository.findById(suministroID).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<SuministroEntity> findAll() {
		// TODO Auto-generated method stub
		return suministrorepository.findAll();
	}

}
