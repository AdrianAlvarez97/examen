package com.exampel.examenMiniblogsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampel.examenMiniblogsModel.Persona;
import com.exampel.examenMiniblogsServicios.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
	  @Autowired
	    private PersonaService personaService;

	    @GetMapping
	    public List<Persona> getAllPersonas() {
	        return personaService.getAllPersonas();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
	        return personaService.getPersonaById(id)
	                .map(persona -> ResponseEntity.ok().body(persona))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Persona createPersona(@RequestBody Persona persona) {
	        return personaService.createPersona(persona);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona persona) {
	        return personaService.getPersonaById(id)
	                .map(existingPersona -> {
	                    persona.setId(id);
	                    return ResponseEntity.ok().body(personaService.updatePersona(id, persona));
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
	        return personaService.getPersonaById(id)
	                .map(persona -> {
	                    personaService.deletePersona(id);
	                    return ResponseEntity.noContent().build();
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

}
