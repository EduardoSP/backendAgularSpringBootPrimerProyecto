package com.sadusoft.services;

import java.util.List;
import java.util.Optional;

import com.sadusoft.modelo.Persona;

public interface PersonaService {
	List<Persona>listar();
	Optional<Persona> listarId(int id);
	Persona add(Persona p);
	Persona edit(Persona p);
	Optional<Persona> delete(int id);

}
