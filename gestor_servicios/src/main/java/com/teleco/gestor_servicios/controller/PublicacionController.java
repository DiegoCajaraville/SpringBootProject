package com.teleco.gestor_servicios.controller;

//import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teleco.gestor_servicios.dto.PublicacionDto;
import com.teleco.gestor_servicios.dto.PublicacionResponse;
import com.teleco.gestor_servicios.service.PublicacionServicio;
import com.teleco.gestor_servicios.utilities.AppConstants;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionServicio publicacionServicio;

    @GetMapping
    public PublicacionResponse listarPublicaciones(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.PAGE_NUM, required = false) int numPage,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.ORDER_BY, required = false) String orderBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
        
        return publicacionServicio.obtenerPublicaciones(numPage, pageSize, orderBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDto> obtenerPublicacionPorID(@PathVariable(name = "id") long id) {

        return new ResponseEntity<>(publicacionServicio.obtenerPublicacionPorID(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<PublicacionDto> guardarPublicacion(@RequestBody PublicacionDto publicacionDto) {

        return new ResponseEntity<>(
                publicacionServicio.crearPublicacion(publicacionDto),
                HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDto> actualizarPublicacion(@PathVariable(name = "id") long id,
            @RequestBody PublicacionDto publicacionDto) {

        return new ResponseEntity<>(
            publicacionServicio.actualizarPublicacion(publicacionDto, id),
            HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") long id) {

        publicacionServicio.eliminarPublicacion(id);
        return new ResponseEntity<>(
                "Publicacion eliminada con éxito",
                HttpStatus.OK);

    }
}
