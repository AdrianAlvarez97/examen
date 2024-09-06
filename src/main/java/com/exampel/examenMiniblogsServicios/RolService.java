package com.exampel.examenMiniblogsServicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampel.examenMiniblogsModel.Rol;
import com.exampel.examenMiniblogsRepository.RolRepository;

@Service
public class RolService {
		  @Autowired
		    private RolRepository rolRepository;

		    public List<Rol> getAllRoles() {
		        return rolRepository.findAll();
		    }

		    public Optional<Rol> getRolById(Long id) {
		        return rolRepository.findById(id);
		    }

		    public Rol createRol(Rol rol) {
		        return rolRepository.save(rol);
		    }

		    public Rol updateRol(Long id, Rol rol) {
		        rol.setId(id);
		        return rolRepository.save(rol);
		    }

		    public void deleteRol(Long id) {
		        rolRepository.deleteById(id);
		    }
		}