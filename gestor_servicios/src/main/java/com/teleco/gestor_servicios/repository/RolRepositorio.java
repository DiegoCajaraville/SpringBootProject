package com.teleco.gestor_servicios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teleco.gestor_servicios.entities.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long>{

    public Optional<Rol> findByNombre(String nombre);
    
}
