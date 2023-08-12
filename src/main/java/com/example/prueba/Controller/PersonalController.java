package com.example.prueba.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.Entity.PersonalEntity;
import com.example.prueba.Service.PersonalService;



@RestController
@RequestMapping("/Personal")
public class PersonalController {
	@Autowired
	private PersonalService personalservice;
	@GetMapping("/listar")
	public ResponseEntity<?>Listar_GET(){
        Collection<PersonalEntity>personalDb=personalservice.findAll();
        if(personalDb.isEmpty()) {
            return new ResponseEntity<>(personalDb,HttpStatus.OK);
        }
        return new ResponseEntity<>(personalDb,HttpStatus.OK);
    }
	@DeleteMapping("Eliminar/{id}")
    public ResponseEntity<Void> deleteHuesped(@PathVariable Integer id) {
        boolean success = personalservice.deletePersonal(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	

}
