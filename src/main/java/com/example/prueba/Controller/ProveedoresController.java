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
import com.example.prueba.Service.ProveedorService;



@RestController
@RequestMapping("/Proveedor")
public class ProveedoresController {
	@Autowired
	private ProveedorService proveedorservice;
	@GetMapping("/listar")
	public ResponseEntity<?>Listar_GET(){
        Collection<ProveedoresEntity>ProveedorDb=proveedorservice.findAll();
        if(ProveedorDb.isEmpty()) {
            return new ResponseEntity<>(ProveedorDb,HttpStatus.OK);
        }
        return new ResponseEntity<>(ProveedorDb,HttpStatus.OK);
    }
	@DeleteMapping("Eliminar/{id}")
    public ResponseEntity<Void> deleteHuesped(@PathVariable Integer id) {
        boolean success = proveedorservice.deleteProveedor(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@PostMapping("/Crear")
    public ResponseEntity<?> createEstado(@RequestBody ProveedoresEntity proveedorDto) {
		proveedorservice.insert(proveedorDto);
		return new ResponseEntity<>("Proveedor Registrado",HttpStatus.CREATED);
    }

}
