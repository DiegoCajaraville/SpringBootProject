package com.teleco.gestor_servicios.service;

//import java.util.List;

import com.teleco.gestor_servicios.dto.PublicacionDto;
import com.teleco.gestor_servicios.dto.PublicacionResponse;

public interface PublicacionServicio {
    
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto);

    // Sin formatear la respuesta, solo una lista
    // public List<PublicacionDto> obtenerPublicaciones(int numPage, int pageSize);
    public PublicacionResponse obtenerPublicaciones(int numPage, int pageSize, String orderBy, String sortDir);

    public PublicacionDto obtenerPublicacionPorID(long id);

    public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, long id);

    public void eliminarPublicacion(long id);
}
