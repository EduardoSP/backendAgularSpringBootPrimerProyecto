package com.sadusoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadusoft.modelo.Persona;
import com.sadusoft.services.PersonaService;

//se va a comunicar directamente con el front end

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/personas"})
public class controlador {
	@Autowired
	PersonaService service;
	
	@GetMapping
	public List<Persona>listar(){
		//nota evaluar si esta bien la instancia o es con personaserviceimp
		return service.listar();
	}
	
	@PostMapping
	public Persona agregar(@RequestBody Persona p) {
		return service.add(p);
	}
	
	@GetMapping(path = {"/{id}"})
	public Optional<Persona> listarId(@PathVariable("id") int id) {
		return service.listarId(id);
		
	}
	
	@PutMapping(path = {"/{id}"})
	public Persona editar(@RequestBody Persona p, @PathVariable("id") int id) {
		p.setId(id);
		return service.edit(p);
	}
	
	@DeleteMapping(path = {"/{id}"})
	public Optional<Persona> delete( @PathVariable("id") int id) {
		return service.delete(id);
	}
	
	
	

}
