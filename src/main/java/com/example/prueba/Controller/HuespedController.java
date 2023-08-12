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


import com.example.prueba.Entity.HuespedEntity;
import com.example.prueba.Service.HuespedService;



@RestController
@RequestMapping("/Huespedes")
public class HuespedController {
	@Autowired
	private HuespedService huespedservice;
	@GetMapping("/listar")
	public ResponseEntity<?>Listar_GET(){
        Collection<HuespedEntity>huespedDb=huespedservice.findAll();
        if(huespedDb.isEmpty()) {
            return new ResponseEntity<>(huespedDb,HttpStatus.OK);
        }
        return new ResponseEntity<>(huespedDb,HttpStatus.OK);
    }
	@DeleteMapping("Eliminar/{id}")
    public ResponseEntity<Void> deleteHuesped(@PathVariable Integer id) {
        boolean success = huespedservice.deleteHuesped(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@PostMapping("/Crear")
    public ResponseEntity<?> createEstado(@RequestBody HuespedEntity huespedDto) {
		huespedservice.insert(huespedDto);
		return new ResponseEntity<>("Huesped Registrado",HttpStatus.CREATED);
    }

}
