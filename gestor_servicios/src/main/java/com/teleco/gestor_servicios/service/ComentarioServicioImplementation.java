package com.teleco.gestor_servicios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.teleco.gestor_servicios.dto.ComentarioDTO;
import com.teleco.gestor_servicios.entities.Comentario;
import com.teleco.gestor_servicios.entities.Publicacion;
import com.teleco.gestor_servicios.exceptions.BlogAppException;
import com.teleco.gestor_servicios.exceptions.ResourceNotFoundException;
import com.teleco.gestor_servicios.repository.ComentarioRepositorio;
import com.teleco.gestor_servicios.repository.PublicacionRepositorio;

@Service
public class ComentarioServicioImplementation implements ComentarioServicio {

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    @Override
    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO) {
        
        Comentario comentario = transformToEntity(comentarioDTO);

        Publicacion publicacion = publicacionRepositorio.findById(publicacionId)
            .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));

        comentario.setPublicacion(publicacion);
        Comentario newComentario = comentarioRepositorio.save(comentario);
        
        return transformToDTO(newComentario);
    }

    @Override
    public List<ComentarioDTO> obtenerComentariosPorPublicacion(long publicacionId) {
        
        List<Comentario> comentarios = comentarioRepositorio.findByPublicacionId(publicacionId);
        return comentarios.stream().map(comentario -> transformToDTO(comentario)).collect(Collectors.toList());
    }

    @Override
    public ComentarioDTO obtenerComentarioPorId(long publicacionId, long comentarioId) {
        
        Publicacion publicacion = publicacionRepositorio.findById(publicacionId)
            .orElseThrow( () -> new ResourceNotFoundException("Publicacion", "id", publicacionId) );

        Comentario comentario = comentarioRepositorio.findById(comentarioId)
            .orElseThrow( () -> new ResourceNotFoundException("Comentario", "id", comentarioId) );

        if ( !comentario.getPublicacion().getId().equals(publicacion.getId()) ) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }

        return transformToDTO(comentario);
    }

    @Override
    public ComentarioDTO actualizarComentario(long publicacionId, long comentarioId, ComentarioDTO solicitudComentario) {

        Publicacion publicacion = publicacionRepositorio.findById(publicacionId)
            .orElseThrow( () -> new ResourceNotFoundException("Publicacion", "id", publicacionId) );

        Comentario comentario = comentarioRepositorio.findById(comentarioId)
            .orElseThrow( () -> new ResourceNotFoundException("Comentario", "id", comentarioId) );

        if ( !comentario.getPublicacion().getId().equals(publicacion.getId()) ) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }

        comentario.setNombre(solicitudComentario.getNombre());
        comentario.setEmail(solicitudComentario.getEmail());
        comentario.setBody(solicitudComentario.getBody());

        Comentario comentarioActualizado = comentarioRepositorio.save(comentario);

        return transformToDTO(comentarioActualizado);
    }

    @Override
    public void eliminarComentario(long publicacionId, long comentarioId) {
        
        Publicacion publicacion = publicacionRepositorio.findById(publicacionId)
            .orElseThrow( () -> new ResourceNotFoundException("Publicacion", "id", publicacionId) );

        Comentario comentario = comentarioRepositorio.findById(comentarioId)
            .orElseThrow( () -> new ResourceNotFoundException("Comentario", "id", comentarioId) );

        if ( !comentario.getPublicacion().getId().equals(publicacion.getId()) ) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicacion");
        }

        comentarioRepositorio.delete(comentario);

        return;
    }

    private ComentarioDTO transformToDTO(Comentario comentario) {

        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setId(comentario.getId());
        comentarioDTO.setNombre(comentario.getNombre());
        comentarioDTO.setEmail(comentario.getEmail());
        comentarioDTO.setBody(comentario.getBody());

        return comentarioDTO;
    }
    
    private Comentario transformToEntity(ComentarioDTO comentarioDTO) {
        
        Comentario comentario = new Comentario();
        comentario.setId(comentarioDTO.getId());
        comentario.setNombre(comentarioDTO.getNombre());
        comentario.setEmail(comentarioDTO.getEmail());
        comentario.setBody(comentarioDTO.getBody());

        return comentario;
    }

    
}
