package com.sadusoft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadusoft.modelo.Persona;
import com.sadusoft.repository.PersonaRepositorio;

@Service
public class PersonaServiceImp implements PersonaService {
	
	@Autowired
	private PersonaRepositorio repositorio;

	@Override
	public List<Persona> listar() {
		return repositorio.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Persona add(Persona p) {
		return repositorio.save(p);
	}

	@Override
	public Persona edit(Persona p) {
		return repositorio.save(p);
	}

	@Override
	public Optional<Persona> delete(int id) {
		Optional<Persona> p = repositorio.findById(id);
		if(p!=null) {
			repositorio.deleteById(id);;
		}
		return p;
	}

}
