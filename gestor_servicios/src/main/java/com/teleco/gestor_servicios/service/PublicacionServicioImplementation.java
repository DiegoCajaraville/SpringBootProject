package com.teleco.gestor_servicios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.teleco.gestor_servicios.dto.PublicacionDto;
import com.teleco.gestor_servicios.dto.PublicacionResponse;
import com.teleco.gestor_servicios.entities.Publicacion;
import com.teleco.gestor_servicios.exceptions.ResourceNotFoundException;
import com.teleco.gestor_servicios.repository.PublicacionRepositorio;

@Service
public class PublicacionServicioImplementation implements PublicacionServicio {

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto) {

        // Convertimos DTO a entidad
        Publicacion publicacion = transformToEntity(publicacionDto);

        // Guardamos en la BBDD
        Publicacion nuevaPublicacion = publicacionRepositorio.save(publicacion);

        // Convertimos de entidad a DTO, y lo devolvemos
        return transformToDTO(nuevaPublicacion);
    }

    @Override
    //public List<PublicacionDto> obtenerPublicaciones(int numPage, int pageSize) {
    public PublicacionResponse obtenerPublicaciones(int numPage, int pageSize, String orderBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();
        Pageable pageable = PageRequest.of(numPage, pageSize, sort);
        Page<Publicacion> publicaciones = publicacionRepositorio.findAll(pageable);

        // Método sin paginacion
        //List<Publicacion> listaPublicaciones = publicacionRepositorio.findAll();
        List<Publicacion> listaPublicaciones = publicaciones.getContent();
        List<PublicacionDto> content = listaPublicaciones.stream().map(publicacion -> transformToDTO(publicacion)).collect(Collectors.toList());

        PublicacionResponse response = new PublicacionResponse();
        response.setContenido(content);
        response.setPageNo(publicaciones.getNumber());
        response.setPageSize(publicaciones.getSize());
        response.setTotalElementos(publicaciones.getTotalElements());
        response.setTotalPaginas(publicaciones.getTotalPages());
        response.setUltima(publicaciones.isLast());

        return response;
    }

    @Override
    public PublicacionDto obtenerPublicacionPorID(long id) {
        
        Publicacion publicacion = publicacionRepositorio.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("Publicacion", "ID", id) );

        return transformToDTO(publicacion);

    }

    @Override
    public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, long id) {
        
        Publicacion publicacion = publicacionRepositorio.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("Publicacion", "ID", id) );

        // Actualizamos los datos
        publicacion.setTitulo(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());

        // Guardamos el nuevo contenido
        Publicacion publicacionActualizada = publicacionRepositorio.save(publicacion);
        return transformToDTO(publicacionActualizada);
    }

    @Override
    public void eliminarPublicacion(long id) {

        Publicacion publicacion = publicacionRepositorio.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("Publicacion", "ID", id) );

        publicacionRepositorio.delete(publicacion);
        
    }

    /**
     * Este método convierte un DTO a una entidad
     * @param publicacionDto
     * @return
     */
    private Publicacion transformToEntity(PublicacionDto publicacionDto) {

        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());

        return publicacion;

    }

    /**
     * Este método convierte una entidad a un DTO
     * @param publicacion
     * @return
     */
    private PublicacionDto transformToDTO(Publicacion publicacion) {

        PublicacionDto publicacionDto = new PublicacionDto();
        publicacionDto.setId(publicacion.getId());
        publicacionDto.setTitulo(publicacion.getTitulo());
        publicacionDto.setDescripcion(publicacion.getDescripcion());
        publicacionDto.setContenido(publicacion.getContenido());

        return publicacionDto;

    }


}
