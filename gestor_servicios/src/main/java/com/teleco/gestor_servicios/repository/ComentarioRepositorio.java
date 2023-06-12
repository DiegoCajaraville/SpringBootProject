package com.teleco.gestor_servicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teleco.gestor_servicios.entities.Comentario;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {
    
    public List<Comentario> findByPublicacionId(long publicacionId);
}
