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

import com.example.prueba.Entity.PagosEntity;
import com.example.prueba.Service.PagosService;







@RestController
@RequestMapping("/pagos")
public class PagosController {
	
	@Autowired
	private PagosService pagosService;
	
	public PagosController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET()
	{
		Collection<PagosEntity> pagosDb=pagosService.findAll();

		
		if(pagosDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(pagosDb,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_GET(@RequestBody PagosEntity pagos)
	{
		pagosService.insert(pagos);
		return new ResponseEntity<>("¡Producto registrado!",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{pagoId}")
	public ResponseEntity<?> editar_PUT(@RequestBody PagosEntity pagos,@PathVariable Integer pagoId)
	{
		PagosEntity pagosDb=pagosService.findById(pagoId);
		
		if(pagosDb!=null)
		{
			pagosDb.setMonto(pagos.getMonto());	
			
			
			pagosService.update(pagosDb);
			return new ResponseEntity<>("¡Producto actualizado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{pagoId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer pagoId)
	{
		PagosEntity pagosDb=pagosService.findById(pagoId);
		
		if(pagosDb!=null)
		{
			pagosService.delete(pagoId);
			return new ResponseEntity<>("¡Producto eliminado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{pagoId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer pagoId)
	{
		PagosEntity pagosDb=pagosService.findById(pagoId);
		
		if(pagosDb!=null) {
			return new ResponseEntity<>(pagosDb,HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!",HttpStatus.NOT_FOUND);
	}

}
