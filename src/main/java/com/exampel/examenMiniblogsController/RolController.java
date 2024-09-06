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

import com.exampel.examenMiniblogsModel.Rol;
import com.exampel.examenMiniblogsServicios.RolService;

@RestController
@RequestMapping("/api/roles")

public class RolController {
	   @Autowired
	    private RolService rolService;

	    // Obtener todos los roles
	    @GetMapping
	    public List<Rol> getAllRoles() {
	        return rolService.getAllRoles();
	    }

	    // Obtener un rol por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
	        return rolService.getRolById(id)
	                .map(rol -> ResponseEntity.ok().body(rol))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Crear un nuevo rol
	    @PostMapping
	    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
	        Rol createdRol = rolService.createRol(rol);
	        return ResponseEntity.ok().body(createdRol);
	    }

	    // Actualizar un rol existente
	    @PutMapping("/{id}")
	    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rol) {
	        return rolService.getRolById(id)
	                .map(existingRol -> {
	                    rol.setId(id);
	                    Rol updatedRol = rolService.updateRol(id, rol);
	                    return ResponseEntity.ok().body(updatedRol);
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Eliminar un rol por ID
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
	        return rolService.getRolById(id)
	                .map(rol -> {
	                    rolService.deleteRol(id);
	                    return ResponseEntity.noContent().build();
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }
}
