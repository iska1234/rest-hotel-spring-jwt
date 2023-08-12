package com.example.prueba.Service;

import java.util.Collection;

import com.example.prueba.Entity.ReservacionEntity;



public interface ReservacionService {
	public abstract void insert(ReservacionEntity reservacion);
	public abstract void update(ReservacionEntity reservacion);
	public abstract void delete(Integer reservacionID );
	public abstract ReservacionEntity findById(Integer reservacionID);
	public abstract Collection<ReservacionEntity>findAll();

}
