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

import com.exampel.examenMiniblogsModel.Usuario;
import com.exampel.examenMiniblogsServicios.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariController {
	 @Autowired
	    private UsuarioService usuarioService;

	    @GetMapping
	    public List<Usuario> getAllUsuarios() {
	        return usuarioService.getAllUsuarios();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
	        return usuarioService.getUsuarioById(id)
	                .map(usuario -> ResponseEntity.ok().body(usuario))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Usuario createUsuario(@RequestBody Usuario usuario) {
	        return usuarioService.createUsuario(usuario);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
	        return usuarioService.getUsuarioById(id)
	                .map(existingUsuario -> {
	                    usuario.setId(id);
	                    return ResponseEntity.ok().body(usuarioService.updateUsuario(id, usuario));
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
	        return usuarioService.getUsuarioById(id)
	                .map(usuario -> {
	                    usuarioService.deleteUsuario(id);
	                    return ResponseEntity.noContent().build();
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

}
