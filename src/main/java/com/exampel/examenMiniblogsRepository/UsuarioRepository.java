package com.exampel.examenMiniblogsRepository;
import com.exampel.examenMiniblogsModel.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
