package com.example.prueba.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.Entity.ProveedoresEntity;
import com.example.prueba.Entity.ReservacionEntity;
import com.example.prueba.Service.ReservacionService;


@RestController
@RequestMapping("/Reservacion")
public class ReservacionController {
	@Autowired
	private ReservacionService reservacionservice;
	@GetMapping("/listar")
	public ResponseEntity<?>Listar_GET(){
        Collection<ReservacionEntity>reservacionDb=reservacionservice.findAll();
        if(reservacionDb.isEmpty()) {
            return new ResponseEntity<>(reservacionDb,HttpStatus.OK);
        }
        return new ResponseEntity<>(reservacionDb,HttpStatus.OK);
    }
	@PostMapping("/Crear")
    public ResponseEntity<?> createEstado(@RequestBody ReservacionEntity reservacionDto) {
		reservacionservice.insert(reservacionDto);
		return new ResponseEntity<>("Reservacion Registrado",HttpStatus.CREATED);
    }

}
