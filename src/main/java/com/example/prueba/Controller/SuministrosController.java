package com.example.prueba.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.Entity.SuministroEntity;
import com.example.prueba.Service.SuministroService;






@RestController
@RequestMapping("/suministros")
public class SuministrosController {
	
	@Autowired
	private SuministroService suministroService;
	
	public SuministrosController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET()
	{
		Collection<SuministroEntity> suministroDb=suministroService.findAll();

		
		if(suministroDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(suministroDb,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_GET(@RequestBody SuministroEntity suministro)
	{
		suministroService.insert(suministro);
		return new ResponseEntity<>("¡Producto registrado!",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{suministroID}")
	public ResponseEntity<?> editar_PUT(@RequestBody SuministroEntity suministro,@PathVariable Integer suministroID)
	{
		SuministroEntity suministroDb=suministroService.findById(suministroID);
		
		if(suministroDb!=null)
		{
			suministroDb.setNombre(suministro.getNombre());
			suministroDb.setDescripcion(suministro.getDescripcion());
			suministroDb.setUnidadDeMedida(suministro.getUnidadDeMedida());
			suministroDb.setStock(suministro.getStock());
			
			
			suministroService.update(suministroDb);
			return new ResponseEntity<>("¡Producto actualizado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{suministroID}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer suministroID)
	{
		SuministroEntity suministroDb=suministroService.findById(suministroID);
		
		if(suministroDb!=null)
		{
			suministroService.delete(suministroID);
			return new ResponseEntity<>("¡Producto eliminado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{suministroID}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer suministroID)
	{
		SuministroEntity suministroDb=suministroService.findById(suministroID);
		
		if(suministroDb!=null) {
			return new ResponseEntity<>(suministroDb,HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!",HttpStatus.NOT_FOUND);
	}

}
