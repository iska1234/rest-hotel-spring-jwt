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


import com.example.prueba.Entity.EstadoMantenimientoEntity;
import com.example.prueba.Service.EstadoMantenimientoService;

@RestController
@RequestMapping("/EstadoMantenimiento")
public class EstadoMantenimientoController {
	@Autowired
	private EstadoMantenimientoService estadomantenimientoservice;
	@GetMapping("/listar")
	public ResponseEntity<?>Listar_GET(){
        Collection<EstadoMantenimientoEntity>estadoDb=estadomantenimientoservice.findAll();
        if(estadoDb.isEmpty()) {
            return new ResponseEntity<>(estadoDb,HttpStatus.OK);
        }
        return new ResponseEntity<>(estadoDb,HttpStatus.OK);
    }
	@DeleteMapping("Eliminar/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer id) {
        boolean success = estadomantenimientoservice.deleteEstadoMantenimiento(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@PostMapping("/Crear")
    public ResponseEntity<?> createEstado(@RequestBody EstadoMantenimientoEntity estadomantenimientoDto) {
		estadomantenimientoservice.insert(estadomantenimientoDto);
		return new ResponseEntity<>("Estado de Mantenimiento Registrada",HttpStatus.CREATED);
    }

}
