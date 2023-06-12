package com.teleco.gestor_servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teleco.gestor_servicios.entities.Publicacion;

public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {
    
}
