package com.exampel.examenMiniblogsServicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampel.examenMiniblogsModel.Publicacion;
import com.exampel.examenMiniblogsRepository.PublicacionRepository;

@Service
public class PublicacionService {
		 @Autowired
		    private PublicacionRepository publicacionRepository;

		    public List<Publicacion> getAllPublicaciones() {
		        return publicacionRepository.findAll();
		    }

		    public Optional<Publicacion> getPublicacionById(Long id) {
		        return publicacionRepository.findById(id);
		    }

		    public Publicacion createPublicacion(Publicacion publicacion) {
		        return publicacionRepository.save(publicacion);
		    }

		    public Publicacion updatePublicacion(Long id, Publicacion publicacion) {
		        publicacion.setId(id);
		        return publicacionRepository.save(publicacion);
		    }

		    public void deletePublicacion(Long id) {
		        publicacionRepository.deleteById(id);
		    }
		
}
