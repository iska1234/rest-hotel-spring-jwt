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

import com.example.prueba.Entity.EstadoHabitacionEntity;

import com.example.prueba.Service.EstadoHabitacionService;


@RestController
@RequestMapping("/EstadoHabitacion")
public class EstadoHabitacionController {
	@Autowired
	private EstadoHabitacionService estadohabitacionservicio;
	@GetMapping("/listar")
	public ResponseEntity<?>Listar_GET(){
        Collection<EstadoHabitacionEntity>estadoDb=estadohabitacionservicio.findAll();
        if(estadoDb.isEmpty()) {
            return new ResponseEntity<>(estadoDb,HttpStatus.OK);
        }
        return new ResponseEntity<>(estadoDb,HttpStatus.OK);
    }
	@DeleteMapping("Eliminar/{id}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable Integer id) {
        boolean success = estadohabitacionservicio.deleteEstadoHabitacion(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@PostMapping("/Crear")
    public ResponseEntity<?> createEstado(@RequestBody EstadoHabitacionEntity estadohabitacionDto) {
		estadohabitacionservicio.insert(estadohabitacionDto);
		return new ResponseEntity<>("Cita Registrada",HttpStatus.CREATED);
    }
	
	

}
