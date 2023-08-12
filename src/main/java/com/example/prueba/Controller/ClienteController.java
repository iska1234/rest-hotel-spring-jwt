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

import com.example.prueba.Entity.ClienteEntity;
import com.example.prueba.Service.ClienteService;






@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	public ClienteController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET()
	{
		Collection<ClienteEntity> clientesDb=clienteService.findAll();

		
		if(clientesDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(clientesDb,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_GET(@RequestBody ClienteEntity cliente)
	{
		clienteService.insert(cliente);
		return new ResponseEntity<>("¡Cliente registrado!",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{clienteId}")
	public ResponseEntity<?> editar_PUT(@RequestBody ClienteEntity cliente,@PathVariable Integer clienteId)
	{
		ClienteEntity clientesDb=clienteService.findById(clienteId);
		
		if(clientesDb!=null)
		{
			clientesDb.setNombres(cliente.getNombres());
			clientesDb.setApellidos(cliente.getApellidos());
			clientesDb.setDni(cliente.getDni());
			clientesDb.setTelefono(cliente.getTelefono());
			
			
			
			clienteService.update(clientesDb);
			return new ResponseEntity<>("¡Cliente actualizado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Cliente no encontrado!",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{clienteId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer clienteId)
	{
		ClienteEntity clientesDb=clienteService.findById(clienteId);
		
		if(clientesDb!=null)
		{
			clienteService.delete(clienteId);
			return new ResponseEntity<>("¡Cliente eliminado!",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Cliente no encontrado!",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{clienteId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer clienteId)
	{
		ClienteEntity clientesDb=clienteService.findById(clienteId);
		
		if(clientesDb!=null) {
			return new ResponseEntity<>(clientesDb,HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>("¡Cliente no encontrado!",HttpStatus.NOT_FOUND);
	}

}
