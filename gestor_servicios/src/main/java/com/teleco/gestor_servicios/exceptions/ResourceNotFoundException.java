package com.teleco.gestor_servicios.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String nombreRecurso;
    private String nombreCampo;
    private long valorCampo;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String nombreRecurso, String nombreCampo, long valorCampo) {
        super(String.format("%s no encontrado con : %s : '%s'", nombreRecurso, nombreCampo, valorCampo));
        this.nombreRecurso = nombreRecurso;
        this.nombreCampo = nombreCampo;
        this.valorCampo = valorCampo;
    }

    /**
     * @return the nombreRecurso
     */
    public String getNombreRecurso() {
        return nombreRecurso;
    }

    /**
     * @param nombreRecurso the nombreRecurso to set
     */
    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    /**
     * @return the nombreCampo
     */
    public String getNombreCampo() {
        return nombreCampo;
    }

    /**
     * @param nombreCampo the nombreCampo to set
     */
    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    /**
     * @return the valorCampo
     */
    public long getValorCampo() {
        return valorCampo;
    }

    /**
     * @param valorCampo the valorCampo to set
     */
    public void setValorCampo(long valorCampo) {
        this.valorCampo = valorCampo;
    }
    
    
}
