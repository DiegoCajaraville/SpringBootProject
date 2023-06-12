package com.teleco.gestor_servicios.service;

import java.util.List;

import com.teleco.gestor_servicios.dto.ComentarioDTO;

public interface ComentarioServicio {

    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO);

    public List<ComentarioDTO> obtenerComentariosPorPublicacion(long publicacionId);

    public ComentarioDTO obtenerComentarioPorId(long publicacionId, long comentarioId);
    
    public ComentarioDTO actualizarComentario(long publicacionId, long comentarioId, ComentarioDTO solicitudComentario);

    public void eliminarComentario(long publicacionId, long comentarioId);
}
