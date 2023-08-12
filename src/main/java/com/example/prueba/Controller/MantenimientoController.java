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


import com.example.prueba.Entity.MantenimientoEntity;
import com.example.prueba.Service.MantenimientoService;

@RestController
@RequestMapping("/Mantenimiento")
public class MantenimientoController {
	@Autowired
	private MantenimientoService mantenimientoservice;
	@GetMapping("/listar")
	public ResponseEntity<?>Listar_GET(){
        Collection<MantenimientoEntity>mantenimientoDb=mantenimientoservice.findAll();
        if(mantenimientoDb.isEmpty()) {
            return new ResponseEntity<>(mantenimientoDb,HttpStatus.OK);
        }
        return new ResponseEntity<>(mantenimientoDb,HttpStatus.OK);
    }
	@DeleteMapping("Eliminar/{id}")
    public ResponseEntity<Void> deleteHuesped(@PathVariable Integer id) {
        boolean success = mantenimientoservice.deleteMantenimiento(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@PostMapping("/Crear")
    public ResponseEntity<?> createEstado(@RequestBody MantenimientoEntity mantenimientoDto) {
		mantenimientoservice.insert(mantenimientoDto);
		return new ResponseEntity<>("Huesped Registrado",HttpStatus.CREATED);
    }

}
