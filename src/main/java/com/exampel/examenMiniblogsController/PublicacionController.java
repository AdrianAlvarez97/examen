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

import com.exampel.examenMiniblogsModel.Publicacion;
import com.exampel.examenMiniblogsServicios.PublicacionService;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
	   @Autowired
	    private PublicacionService publicacionService;

	    @GetMapping
	    public List<Publicacion> getAllPublicaciones() {
	        return publicacionService.getAllPublicaciones();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Publicacion> getPublicacionById(@PathVariable Long id) {
	        return publicacionService.getPublicacionById(id)
	                .map(publicacion -> ResponseEntity.ok().body(publicacion))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
	        return publicacionService.createPublicacion(publicacion);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Publicacion> updatePublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
	        return publicacionService.getPublicacionById(id)
	                .map(existingPublicacion -> {
	                    publicacion.setId(id);
	                    return ResponseEntity.ok().body(publicacionService.updatePublicacion(id, publicacion));
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePublicacion(@PathVariable Long id) {
	        return publicacionService.getPublicacionById(id)
	                .map(publicacion -> {
	                    publicacionService.deletePublicacion(id);
	                    return ResponseEntity.noContent().build();
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

}
