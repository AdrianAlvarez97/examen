package com.exampel.examenMiniblogsServicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampel.examenMiniblogsModel.Persona;
import com.exampel.examenMiniblogsRepository.PersonaRepository;

@Service
public class PersonaService {
	 @Autowired
	    private PersonaRepository personaRepository;

	    public List<Persona> getAllPersonas() {
	        return personaRepository.findAll();
	    }

	    public Optional<Persona> getPersonaById(Long id) {
	        return personaRepository.findById(id);
	    }

	    public Persona createPersona(Persona persona) {
	        return personaRepository.save(persona);
	    }

	    public Persona updatePersona(Long id, Persona persona) {
	        persona.setId(id);
	        return personaRepository.save(persona);
	    }

	    public void deletePersona(Long id) {
	        personaRepository.deleteById(id);
	    }

}
