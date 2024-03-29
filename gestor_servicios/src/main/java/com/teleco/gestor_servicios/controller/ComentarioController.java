package com.teleco.gestor_servicios.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teleco.gestor_servicios.dto.ComentarioDTO;
import com.teleco.gestor_servicios.service.ComentarioServicioImplementation;

@RestController
@RequestMapping("/api/")
public class ComentarioController {

    @Autowired
    private ComentarioServicioImplementation comentarioServicio;

    @GetMapping("/publicaciones/{publicacionId}/comentarios")
    public List<ComentarioDTO> listarComentariosPorPublicacion(@PathVariable(value = "publicacionId") long publicacionId) {

        return comentarioServicio.obtenerComentariosPorPublicacion(publicacionId);
    }

    @GetMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> obtenerComentarioPorId(@PathVariable(value = "publicacionId") long publicacionId, @PathVariable(value = "id") long comentarioId) {
        
        return new ResponseEntity<ComentarioDTO>(comentarioServicio.obtenerComentarioPorId(publicacionId, comentarioId), HttpStatus.OK);
    }

    @PostMapping("/publicaciones/{publicacionId}/comentarios")
    public ResponseEntity<ComentarioDTO> guardarComentario(@PathVariable(value = "publicacionId") long publicacionId, @Valid @RequestBody ComentarioDTO comentarioDTO) {

        return new ResponseEntity<ComentarioDTO>(comentarioServicio.crearComentario(publicacionId, comentarioDTO), HttpStatus.CREATED);

    }

    @PutMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> actualizarComentario(@PathVariable(value = "publicacionId") long publicacionId, @PathVariable(value = "id") long comentarioId, @Valid @RequestBody ComentarioDTO comentarioDTO) {

        return new ResponseEntity<ComentarioDTO>(comentarioServicio.actualizarComentario(publicacionId, comentarioId, comentarioDTO), HttpStatus.OK);
    }

    @DeleteMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable(value = "publicacionId") long publicacionId, @PathVariable(value = "id") long comentarioId) {
        
        comentarioServicio.eliminarComentario(publicacionId, comentarioId);

        return new ResponseEntity<String>(
                "Comentario eliminado con éxito",
                HttpStatus.OK
        );
    
    }
}
