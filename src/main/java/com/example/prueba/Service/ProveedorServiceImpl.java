package com.example.prueba.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.Entity.HuespedEntity;
import com.example.prueba.Entity.ProveedoresEntity;
import com.example.prueba.Repository.ProveedoresRepository;
@Service
public class ProveedorServiceImpl implements ProveedorService{
	@Autowired
	private ProveedoresRepository proveedorerepository;

	@Override
	public void insert(ProveedoresEntity proveedores) {
		// TODO Auto-generated method stub
		proveedorerepository.save(proveedores);
	}

	@Override
	public void update(ProveedoresEntity proveedores) {
		// TODO Auto-generated method stub
		proveedorerepository.save(proveedores);
	}

	@Override
	public void delete(Integer proveedoresID) {
		// TODO Auto-generated method stub
		proveedorerepository.deleteById(proveedoresID);
	}

	@Override
	public ProveedoresEntity findById(Integer proveedoresID) {
		// TODO Auto-generated method stub
		return proveedorerepository.findById(proveedoresID).orElse(null);
	}

	@Override
	public Collection<ProveedoresEntity> findAll() {
		// TODO Auto-generated method stub
		return proveedorerepository.findAll();
	}

	@Override
	public boolean deleteProveedor(Integer proveedorID) {
		Optional<ProveedoresEntity>optionalProveedor=proveedorerepository.findById(proveedorID);
		if(optionalProveedor.isPresent()) {
			ProveedoresEntity proveedor= optionalProveedor.get();
			proveedor.setEstado(false);
			proveedorerepository.save(proveedor);
			return true;
		}else {
		return false;
		}
	}

}
